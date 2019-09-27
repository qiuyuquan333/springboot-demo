package com.qyq.redis.mapper;

import com.qyq.redis.People;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 缓存注解的使用
 *          1.如果不在类指定@cacheConfig的cacheNames属性，那方法上的注解就要指定，不然会报错。
 *          2.@cacheable、@CachePut、@CacheEvict（方法注解）
 */
@CacheConfig(cacheNames = "people")
public interface PeopleMapper2 {

    @Select("select * from people")
    List<People> findList();

    @Cacheable(value = "people",key = "#id")//添加，查询缓存
    @Select("select * from people where id = #{id}")
    People findById(Integer id);

    @Select("select * from people where sex like concat('%',#{sex},'%')")
    List<People> findPeopleBySex(String sex);

    @Insert("insert into people (name,sex,idress) values (#{name},#{sex},#{idress})")
    @SelectKey(statement = "select last_insert_id()",keyProperty = "id",before = false,resultType = Integer.class)
    Integer insertPeople(People people);

    @CachePut(cacheNames = "people",key = "#root.methodName")//更新缓存
    @Update("update people set name=#{name},idress=#{idress} where id=#{id}")
    Integer updatePeople(People people);

    @CacheEvict(key = "#id")//删除缓存
    @Delete("delete from people where id = #{id}")
    Integer deletePeople(Integer id);
}
