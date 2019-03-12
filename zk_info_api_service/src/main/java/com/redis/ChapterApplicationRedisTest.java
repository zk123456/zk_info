package com.redis;

import com.ChapterApplication;
import com.alibaba.fastjson.JSON;
import com.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChapterApplication.class)
public class ChapterApplicationRedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, com.redis.Test> redisTemplate;

    @Test
    public void test1() {
        stringRedisTemplate.opsForValue().set("a", "a");

        String a = stringRedisTemplate.opsForValue().get("a");
        System.out.println(a);
        stringRedisTemplate.delete("a");
        Student s = new Student();
        s.setName("b");
        stringRedisTemplate.opsForValue().set("b", JSON.toJSONString(s));

        String b = stringRedisTemplate.opsForValue().get("b");
        System.out.println(b);
        stringRedisTemplate.delete("b");

        com.redis.Test t = new com.redis.Test("1");
        redisTemplate.opsForValue().set(t.getName(), t);

        System.out.println(redisTemplate.opsForValue().get("1").getName());
    }
}
