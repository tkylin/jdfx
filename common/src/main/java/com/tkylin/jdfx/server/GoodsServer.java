package com.tkylin.jdfx.server;

import com.tkylin.jdfx.db.SessionFactory;
import com.tkylin.jdfx.db.dao.GoodsMapper;
import com.tkylin.jdfx.db.model.Goods;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: tangdq (tkylin@vip.qq.com)
 * Date: 2017/3/17 15:12
 */
public class GoodsServer {
    public static String insertSelective(Goods goods) {
        try {
            goods.setCreateTime(new Date());
            goods.setStatus(1);
            if (StringUtils.isBlank(goods.getSku()) && StringUtils.isNotBlank(goods.getSkuId())) {
                goods.setSku(goods.getSkuId());
            }

            SqlSession session = SessionFactory.getSession();
            GoodsMapper dao = session.getMapper(GoodsMapper.class);
            dao.insertSelective(goods);
            session.commit();
            session.close();
            return goods.getSkuId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> batchInsertSelective(List<Goods> list) {
        List<String> strings = new ArrayList<String>();
        for (Goods goods : list) {
            String string = insertSelective(goods);
            if (StringUtils.isNotBlank(string)) {
                strings.add(string);
            }
        }
        return strings;
    }
}
