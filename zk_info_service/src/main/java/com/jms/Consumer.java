package com.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author zk
 * @Date 17:39 2019/3/11
 */
@Component
public class Consumer {

    @JmsListener(destination = "test")
    public void receiveMessage(String text) {
        System.out.println("-------------------------" + text);
    }
}
