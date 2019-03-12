package com.test;

import com.ChapterApplication;
import com.chapter.Properties2;
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
public class Chapter2ApplicationTest {

    @Autowired
    private Properties2 properties2;

    @Test
    public void test1() {
        System.out.println("============属性注入===========");
        System.out.println(properties2.getName());
        System.out.println(properties2.getDesc());
        System.out.println(properties2.getTitle());
        System.out.println(properties2.getInfo());
    }
}
