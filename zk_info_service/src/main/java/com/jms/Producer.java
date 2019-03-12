package com.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zk
 * @Date 17:37 2019/3/11
 */
@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(String detinationName, String message) {
        jmsMessagingTemplate.convertAndSend(detinationName, message);
    }
}
