package com.qyq.redis;

import com.qyq.redis.mapper.PeopleMapper2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Test
    public void contextLoads() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations ops = redisTemplate.opsForValue();
        ops .set("name","网易云音乐");
        Object name = ops.get("name");
        System.out.println(name);
    }

    @Test
    public void Test1(){
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set("music","QQ音乐");
        String music = opsForValue.get("music");
        System.out.println(music);
    }

    @Autowired
    private PeopleMapper2 peopleMapper2;

    @Test
    public void Test2(){
        People people = peopleMapper2.findById(3);
        System.out.println(people.toString());
    }

}
