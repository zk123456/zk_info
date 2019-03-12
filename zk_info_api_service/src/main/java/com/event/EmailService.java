package com.event;

import org.springframework.context.ApplicationListener;
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
public class EmailService implements ApplicationListener<UserRegisterEvent>{
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("邮件服务接到通知，给 " + event.getSource() + " 发送邮件...");
    }
}
