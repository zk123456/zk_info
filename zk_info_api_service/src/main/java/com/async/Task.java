package com.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author zk
 * @Date 14:36 2019/3/9
 */
@Component
public class Task {

    /**
     * @Async注解就能简单的将原来的同步函数变为异步函数
     * @EnableAsync 开启@Async注解
     * @Async所修饰的函数不要定义为static类型，这样异步调用不会生效
     *
     * Future可以获取异步调用的结果
     * Future.get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回
     */
    /**
     * 在定义了线程池之后，我们如何让异步调用的执行任务使用这个线程池中的资源来运行呢？方法非常简单，我们只需要在@Async注解中指定线程池名即可.
     * 通过自定义线程池的方式来控制异步调用的并发.
     * @return
     */
    @Async("taskExecutor")
    public Future<String> do1() {
        long start = System.currentTimeMillis();
        System.out.println("do1");
        long end = System.currentTimeMillis();
        System.out.println("任务一完成" + (end - start));
        return new AsyncResult<>("任务一完成");
    }
    @Async("taskExecutor")
    public Future<String> do2() {
        long start = System.currentTimeMillis();
        System.out.println("do2");
        long end = System.currentTimeMillis();
        System.out.println("任务二完成" + (end - start));
        return new AsyncResult<>("任务二完成");
    }
    @Async("taskExecutor")
    public Future<String> do3() {
        long start = System.currentTimeMillis();
        System.out.println("do3");
        long end = System.currentTimeMillis();
        System.out.println("任务三完成" + (end - start));
        return new AsyncResult<>("任务三完成");
    }
}
