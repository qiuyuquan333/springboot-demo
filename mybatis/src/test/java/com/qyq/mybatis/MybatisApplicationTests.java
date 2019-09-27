package com.qyq.mybatis;

import com.qyq.mybatis.datatestmapper.PeopleMapper;
import com.qyq.mybatis.febsmapper.UserMapper;
import com.qyq.mybatis.pojo.People;
import com.qyq.mybatis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Autowired
    private PeopleMapper peopleMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 多数据源测试
     */
    @Test
    public void Test1(){
        List<People> peopleList = peopleMapper.findAll();
        for (People people : peopleList) {
            System.out.println(people.toString());
        }
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

}
