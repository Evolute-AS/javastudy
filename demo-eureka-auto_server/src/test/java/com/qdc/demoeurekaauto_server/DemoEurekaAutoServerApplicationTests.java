package com.qdc.demoeurekaauto_server;

import com.alibaba.druid.pool.DruidDataSource;
import com.qdc.demoeurekaauto_server.mapper.UserMapper;
import com.qdc.demoeurekaauto_server.service.impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoEurekaAutoServerApplicationTests {

    @Autowired
    private DruidDataSource druidDataSource;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Test
    void testUserDetails(){
        System.out.println(userDetailsService.loadUserByUsername("admin"));
    }

    @Test
    void  testUserMapper(){
        System.out.println(userMapper.findByUsername("admin"));
    }
    @Test
    void contextLoads() {
        System.out.println(druidDataSource);
    }
}
