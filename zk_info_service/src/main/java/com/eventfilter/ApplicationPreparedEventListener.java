package com.eventfilter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author Zhangk
 * @Date 17:54 2019/2/21
 * @Description
 */
@Slf4j
public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent>{
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        log.info("====================applicationPreparedEvent");
    }
}
