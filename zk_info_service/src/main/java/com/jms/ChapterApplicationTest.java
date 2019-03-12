package com.jms;

import com.ChapterApplication;
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
@SpringBootTest(classes = ChapterApplication.class)
public class ChapterApplicationTest {

    @Autowired
    private Producer producer;
    @Autowired
    private Producer2 producer2;

    @Test
    public void test1() {
        //点对点
        producer.send("test", "******************");
    }

    @Test
    public void test2() {
        //发布订阅模式
        producer2.send("test2", "******************");
    }

}
