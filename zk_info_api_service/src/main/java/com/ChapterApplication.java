package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.ConnectionFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Zhangk
 * @Date 11:13 2019/2/21
 * @Description
 */

/**
 * @EnableScheduling 开启定时任务配置
 * @EnableAsync 开启异步函数调用
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@RestController
/**
 * 开启缓存功能
 * 具体注入的缓存是按照如下顺序:
 * Generic
 JCache (JSR-107)
 EhCache 2.x
 Hazelcast
 Infinispan
 Redis
 Guava
 Simple
 spring.cache.type= 这个xml配置也可以强制指定缓存策略
 */
@EnableCaching
public class ChapterApplication {
    private Logger logger = LoggerFactory.getLogger(ChapterApplication.class);
    /**
     * 一些事件的执行顺序和时间点
     * 2019-02-22 10:46:27.938  INFO 18140 --- [ main] e.ApplicationStartedEventListener   : ======================applicationStartedEvent
     2019-02-22 10:46:27.939  INFO 18140 --- [ main] DataLoader      : ===============load data
     2019-02-22 10:46:27.939  INFO 18140 --- [main] e.ApplicationReadyEventListener  : ==========================applicationReadyEvent
     * @param args
     */
    public static void main(String[] args) {
        //SpringApplication.run(ChapterApplication.class, args);


        ApplicationContext context = SpringApplication.run(ChapterApplication.class, args);

        /*Binder binder = Binder.get(context.getEnvironment());
        // 绑定List配置
        List<String> title = binder.bind("spring.database.title", Bindable.listOf(String.class)).get();
        System.out.println("==================bind=================");
        System.out.println(title);

        List<Info> infos = binder.bind("spring.database.info", Bindable.listOf(Info.class)).get();
        System.out.println(infos);*/
    }

    @Bean
    JmsListenerContainerFactory myJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }


    /**
     * 动态修改日志级别
     * http://127.0.0.1:8080/actuator/loggers/cn 修改包下的日志等级  cn->具体包名
     *
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testLogLevel() {
        logger.debug("-------------------Logger Level ：DEBUG");
        logger.info("-----------------------Logger Level ：INFO");
        logger.error("-------------------Logger Level ：ERROR");
        return "";
    }

    @EnableAsync
    @Configuration
    class TaskPoolConfig {

        @Bean("taskExecutor")
        public Executor taskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(10);
            executor.setMaxPoolSize(20);
            executor.setQueueCapacity(200);
            executor.setKeepAliveSeconds(60);
            executor.setThreadNamePrefix("taskExecutor-");
            executor.setWaitForTasksToCompleteOnShutdown(true);
            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            return executor;
        }

        @Bean("taskExecutor1")
        public Executor taskExecutor1() {
            ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
            executor.setPoolSize(20);
            executor.setThreadNamePrefix("taskExecutor1-");
            //等待所有任务完成,再关闭容器资源
            //任务中资源的相互依赖的情况下
            executor.setWaitForTasksToCompleteOnShutdown(true);
            return executor;
        }
    }
}
