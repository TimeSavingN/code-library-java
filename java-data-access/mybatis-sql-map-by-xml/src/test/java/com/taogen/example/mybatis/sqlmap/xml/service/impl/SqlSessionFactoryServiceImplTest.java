package com.taogen.example.mybatis.sqlmap.xml.service.impl;

import com.taogen.example.mybatis.sqlmap.xml.service.SqlSessionFactoryService;
import org.junit.Test;

import static org.junit.Assert.*;

public class SqlSessionFactoryServiceImplTest {

    private SqlSessionFactoryService sqlSessionFactoryService = new SqlSessionFactoryServiceImpl();

    @Test
    public void getSqlSessionFactory() {
        assertNotNull(sqlSessionFactoryService.getSqlSessionFactory());
    }
}