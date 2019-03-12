package com.eventfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author Zhangk
 * @Date 17:55 2019/2/21
 * @Description
 */
@Slf4j
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent>{
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info("======================applicationStartedEvent");
    }
}
