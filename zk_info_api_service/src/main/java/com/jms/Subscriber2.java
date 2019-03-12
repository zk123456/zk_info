package com.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author zk
 * @Date 17:45 2019/3/11
 */
@Component
public class Subscriber2 {

    @JmsListener(destination = "test2", containerFactory = "myJmsListenerContainerFactory")
    public void subscriber(String text) {
        System.out.println("-----------2-----------" + text);
    }
}
