package com.eventfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author Zhangk
 * @Date 17:56 2019/2/21
 * @Description
 */
@Slf4j
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent>{
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("==========================applicationReadyEvent");
    }
}
