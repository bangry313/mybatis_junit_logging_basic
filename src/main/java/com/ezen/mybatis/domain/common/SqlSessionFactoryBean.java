package com.ezen.mybatis.domain.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryBean {

    private static final SqlSessionFactoryBean instance = new SqlSessionFactoryBean();

    private static final String resource = "mybatis/mybatis-config.xml";
    private SqlSessionFactoryBean(){ }

    public static SqlSessionFactoryBean getInstance(){
        return instance;
    }

    public SqlSessionFactory getSqlSessionFactory(){
        Reader reader = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSessionFactory;
    }


}
