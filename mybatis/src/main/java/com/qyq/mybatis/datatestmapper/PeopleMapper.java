package com.qyq.mybatis.datatestmapper;

import com.qyq.mybatis.pojo.People;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PeopleMapper {

    @Select("select * from people")
    List<People> findAll();
}
