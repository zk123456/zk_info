package com;

import com.domain.TempUser;
import com.domain.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zk
 * @Date 13:57 2019/3/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        userMapper.insert("aaaa");

        List<TempUser> aaaa = userMapper.findByName("aaaa");
        aaaa.forEach(p -> System.out.println(p.getName()));

        TempUser user2 = new TempUser();
        user2.setName("bbb");
        userMapper.insertByObject(user2);

        Map<String,Object> map = new HashMap<>();
        map.put("name", "ccc");
        userMapper.insertByMap(map);

        List<UserVO> all = userMapper.findAll();
        all.forEach(p -> System.out.println(p.getD()));
    }
}
