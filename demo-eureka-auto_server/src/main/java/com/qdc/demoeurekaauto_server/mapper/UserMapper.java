package com.qdc.demoeurekaauto_server.mapper;

import com.qdc.demoeurekaauto_server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from springcloud_user where username=#{username}")
    public User findByUsername(String username);

}
