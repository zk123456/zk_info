package com.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zk
 * @Date 13:48 2019/3/9
 */
/**
 * @EnableScheduling 开启定时任务配置
 */
@Component
public class ScheduleTask {

    @Scheduled(fixedRate = 1000)
    public void test() {
        System.out.println(LocalDateTime.now().toString());
    }
}
