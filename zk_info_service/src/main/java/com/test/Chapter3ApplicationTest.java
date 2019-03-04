package com.test;

import com.ChapterApplication;
import com.dao.UserRepository;
import com.dao.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Zhangk
 * @Date 14:32 2019/2/21
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * SpringApplicationConfiguration 1.*的版本有这个注解  之后新的版本去掉了
 * 用SpringBootTest 代替
 */
@SpringBootTest(classes = ChapterApplication.class)
public class Chapter3ApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        userRepository.save(new User(3L, "3"));
        userRepository.save(new User(4L, "4"));

        User byName = userRepository.findByName("3");
        System.out.println(byName.getId() + "====" + byName.getName());

        User user = userRepository.findUser("2");
        System.out.println(user.getId() + "====" + user.getName());
    }
}
