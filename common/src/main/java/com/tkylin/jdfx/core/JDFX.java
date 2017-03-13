package com.tkylin.jdfx.core;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.jfinal.kit.PropKit;
import com.tkylin.jdfx.core.dto.FxHhResultDto;
import com.tkylin.jdfx.core.dto.JdfxConfig;
import com.tkylin.jdfx.db.SessionFactory;
import com.tkylin.jdfx.db.dao.GoodsMapper;
import com.tkylin.jdfx.db.model.Goods;
import com.tkylin.jdfx.db.model.GoodsExample;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tkyli on 2017/3/8.
 */
public class JDFX {
    private static JdfxConfig config;
    private static Gson gson;
    private static Logger logger = LoggerFactory.getLogger(JDFX.class);

    static {
        gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        }).create();

        PropKit.use("jdfx.properties", "utf-8");
        config = new JdfxConfig();
        config.setFxApi(PropKit.get("fx.api", ""));
        config.setFxIndex(PropKit.get("fx.index", ""));
        config.setFxHhApi(PropKit.get("fx.hh.api", ""));
        config.setFxHhIndex(PropKit.get("fx.hh.index", ""));
        config.setFxHhIndex(PropKit.get("fx.hh.detail", ""));
        config.setImageSavePath(PropKit.get("image.save.path", ""));
        config.setTimeoutMillis(PropKit.getLong("timeout.millis", 60000L));
    }

    //解析发现好货首页
    public static void loadFxHhIndex() {
        //app=Discovergoods&action=getDiscZdmGoodsList&callback=listCallback&type=goods&tabId=19&page=1&_=1489162729422
        JdParam param = new JdParam();
        param.addParam("app", "Discovergoods");
        param.addParam("action", "getDiscZdmGoodsList");
        param.addParam("callback", "listCallback");
        param.addParam("type", "goods");

        param.addParam("page", "1");
        param.addParam("_", System.currentTimeMillis() + "");
        //精选
        fxHhLoadTab(19);
        //全球优品
        fxHhLoadTab(20);
    }

    public static void loadFxHhDetail(String sku) throws InterruptedException {
        //https://ai.jd.com/index_new.php?app=Discovergoods&action=getDiscZdmGoodsDetail&callback=detailCallback&id=655949&_=1489385568482
        JdParam param = new JdParam();
        param.addParam("app", "Discovergoods");
        param.addParam("action", "getDiscZdmGoodsDetail");
        param.addParam("callback", "detailCallback");
        param.addParam("id", sku);
        param.addParam("_", System.currentTimeMillis() + "");
        String url = config.getFxHhApi() + param.getUrlParams();
        HtmlPage result = H5Client.load(url);
        String content = result.getBody().getFirstChild().getTextContent();
        String json = content.replace("detailCallback(", "").replace(");", "");
        logger.debug(">>>>>>>>>>>>>>>>>>>>>json:{}", json);
        //JsonObject jsonObject
        JsonElement element = new JsonParser().parse(json);
        JsonObject data = element.getAsJsonObject().get("data").getAsJsonObject();
        JsonArray similarRecommend = data.get("similarRecommend").getAsJsonArray();
        List<Goods> list = gson.fromJson(similarRecommend, new TypeToken<List<Goods>>() {
        }.getType());

        List<String> success = save(list);
        Thread.sleep(200);

        //加载单品相关推荐 这个从测试角度来说可能无效
        /*for (String succes : success) {
            loadFxHhDetail(succes);
        }*/
    }

    public static void fxHhLoadTab(int tabId) {
        JdParam param = new JdParam();
        param.addParam("app", "Discovergoods");
        param.addParam("action", "getDiscZdmGoodsList");
        param.addParam("callback", "listCallback");
        param.addParam("type", "goods");
        param.addParam("tabId", "19");
        param.addParam("page", "1");
        param.addParam("tabId", String.valueOf(tabId));

        int page = 1;
        while (page <= 20) {
            param.addParam("page", String.valueOf(page));
            param.addParam("_", System.currentTimeMillis() + "");

            String url = config.getFxHhApi() + param.getUrlParams();

            try {
                fxHhLoadAndSave(url);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                break;
            }

            page++;
        }

    }

    public static void fxHhLoadAndSave(String url) throws InterruptedException {
        logger.debug(">>>>>>>>>>>>>>>>>>>>>url:{}", url);
        HtmlPage result = H5Client.load(url);
        String content = result.getBody().getFirstChild().getTextContent();
        String json = content.replace("listCallback(", "").replace(");", "");
        logger.debug(">>>>>>>>>>>>>>>>>>>>>json:{}", json);
        FxHhResultDto resultDto = gson.fromJson(json, FxHhResultDto.class);

        List<String> list = save(resultDto.getList());
        for (String sku : list) {
            //加载单品相关推荐
            loadFxHhDetail(sku);
        }

        Thread.sleep(200);
    }

    public static List<String> save(List<Goods> list) {
        SqlSession session = SessionFactory.getSession();
        GoodsMapper dao = session.getMapper(GoodsMapper.class);
        List<String> success = new ArrayList<String>();
        for (Goods goods : list) {
            try {
                goods.setCreateTime(new Date());
                goods.setStatus(1);

                dao.insertSelective(goods);

                //下载图片
                download("https:" + goods.getGoodsPic(), goods.getSku());

                success.add(goods.getSku());
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        session.commit();
        session.close();
        return success;
    }

    //小文件下载
    public static void download(String url, String sku) {
        if (StringUtils.isNotBlank(url)) {
            try {
                String imagePath = config.getImageSavePath();
                StringBuilder img = new StringBuilder(imagePath);
                img.append(File.separator).append(sku).append(url.substring(url.lastIndexOf(".")));
                byte[] bytes = IOUtils.toByteArray(new URL(url));
                OutputStream os = new FileOutputStream(new File(img.toString()));
                IOUtils.write(bytes, os);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void downloadAll() {
        SqlSession session = SessionFactory.getSession();
        GoodsMapper dao = session.getMapper(GoodsMapper.class);
        GoodsExample exa = new GoodsExample();
        GoodsExample.Criteria cri = exa.createCriteria();
        cri.andGoodsIdGreaterThan(1090L);
        List<Goods> list = dao.selectByExample(exa);
        for (Goods goods : list) {
            download("https:" + goods.getGoodsPic(), goods.getSku());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        loadFxHhIndex();

        //downloadAll();

        //test recursive
        //loadFxHhDetail("3660371");
    }

}
