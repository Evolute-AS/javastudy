package com.qdc.demoeurekaauto_server.service.impl;

import com.qdc.demoeurekaauto_server.mapper.UserMapper;
import com.qdc.demoeurekaauto_server.pojo.User;
import com.qdc.demoeurekaauto_server.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    static org.slf4j.Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUser(String username){
        return userMapper.findByUsername(username);
    }
}
