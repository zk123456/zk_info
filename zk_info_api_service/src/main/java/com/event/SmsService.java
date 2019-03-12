package com.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @Author Zhangk
 * @Date 16:23 2019/2/18
 * @Description
 */

/**
 * 实现spring时间监听器接口
 */
@Service
public class SmsService {
    /**
     * EventListener注解提供了spring事件监听器的作用
     * @param event
     */
    @EventListener
    public void sendSms(UserRegisterEvent event) {
        System.out.println("发送短信通知，给 " + event.getSource() + " 发送短信...");
    }
}
