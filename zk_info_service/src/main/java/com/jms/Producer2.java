package com.jms;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author zk
 * @Date 17:37 2019/3/11
 */
@Component
public class Producer2 {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(String detinationName, String message) {
        Destination destination = new ActiveMQTopic(detinationName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
