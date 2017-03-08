package com.tkylin.jdfx;

import com.google.gson.Gson;
import com.tkylin.jdfx.db.dao.GoodsMapper;
import com.tkylin.jdfx.db.model.Goods;
import com.tkylin.jdfx.db.model.GoodsExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    static Gson gson=new Gson();
    public static void main(String[] args) {
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sessionFactory.openSession();

            GoodsMapper dao = session.getMapper(GoodsMapper.class);
            GoodsExample exa = new GoodsExample();
            GoodsExample.Criteria cri = exa.createCriteria();
            cri.andSkuEqualTo("2565677");
            List<Goods> list = dao.selectByExample(exa);
            System.out.println(gson.toJson(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
