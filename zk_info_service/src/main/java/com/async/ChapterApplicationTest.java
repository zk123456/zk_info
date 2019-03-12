package com.async;

import com.ChapterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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
public class ChapterApplicationTest {

    @Autowired
    private Task task;

    @Test
    public void test1() {
        task.do1();
        task.do2();
        task.do3();
    }

    @Test
    public void test2() throws Exception{
        Future<String> stringFuture = task.do1();
        Future<String> stringFuture1 = task.do2();
        Future<String> stringFuture2 = task.do3();

        while(true) {
            if(stringFuture.isDone() && stringFuture1.isDone() && stringFuture2.isDone()) {
                //循环判断3个异步任务函数是否已经全部执行完毕
                break;
            }
            Thread.sleep(1000);
        }
        System.out.println("任务完成");
    }

    @Test
    public void test3() throws Exception {

        task.do1();
        task.do2();
        task.do3();

        Future<String> stringFuture = task.do1();
        String s = stringFuture.get(5, TimeUnit.SECONDS);
        /**
         * 我们在get方法中还定义了该线程执行的超时时间，通过执行这个测试我们可以观察到执行时间超过5秒的时候，
         * 这里会抛出超时异常，该执行线程就能够因执行超时而释放回线程池
         */

        //挂起当前主线程,执行子线程
        Thread.currentThread().join();
    }
}
