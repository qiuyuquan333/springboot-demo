package com.qyq.mybatis.febsmapper;

import com.qyq.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();
}
