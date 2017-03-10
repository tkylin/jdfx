package com.tkylin.jdfx.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tkyli on 2017/3/11.
 */
public class SessionFactory {
    private static SqlSessionFactory sessionFactory = null;
    private static final String RESOURCE = "mybatis.xml";
    private static Logger logger = LoggerFactory.getLogger(SessionFactory.class);

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static <T> T getSession(Class<T> clazz) {
        SqlSession session = sessionFactory.openSession();
        return session.getMapper(clazz);
    }
}
