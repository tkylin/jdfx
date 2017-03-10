package com.tkylin.jdfx.core;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.*;
import com.jfinal.kit.PropKit;
import com.tkylin.jdfx.core.dto.FxHhResultDto;
import com.tkylin.jdfx.core.dto.JdfxConfig;
import com.tkylin.jdfx.db.SessionFactory;
import com.tkylin.jdfx.db.dao.GoodsMapper;
import com.tkylin.jdfx.db.model.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.Date;

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
        param.addParam("tabId", "19");
        param.addParam("page", "1");
        param.addParam("_", System.currentTimeMillis() + "");

        String url = config.getFxHhApi() + param.getUrlParams();
        logger.debug(">>>>>>>>>>>>>>>>>>>>>url:{}", url);
        HtmlPage page = H5Client.load(url);
        String content = page.getBody().getFirstChild().getTextContent();
        String json = content.replace("listCallback(", "").replace(");", "");
        logger.debug(">>>>>>>>>>>>>>>>>>>>>json:{}", json);
        FxHhResultDto resultDto = gson.fromJson(json, FxHhResultDto.class);

        GoodsMapper session = SessionFactory.getSession(GoodsMapper.class);
        for (Goods goods : resultDto.getList()) {
            try {
                goods.setCreateTime(new Date());
                goods.setStatus(1);

                session.insertSelective(goods);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    public static void main(String[] args) {
        loadFxHhIndex();
    }

}
