package com.eventfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author Zhangk
 * @Date 17:52 2019/2/21
 * @Description
 */
@Slf4j
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent>{
    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        log.info("=======================applicationStartingEvent");
    }
}
