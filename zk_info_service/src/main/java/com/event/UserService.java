package com.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @Author Zhangk
 * @Date 16:21 2019/2/18
 * @Description
 */

/**
 * 实现
 * ApplicationEventPublisher事件发布器的接口，使用这个接口，我们自己的Service就拥有了发布事件的能力
 */
@Service
public class UserService implements ApplicationEventPublisherAware{

    public void register(String name) {
        System.out.println("用户：" + name + " 已注册！");
        applicationEventPublisher.publishEvent(new UserRegisterEvent(name));
    }

    private ApplicationEventPublisher applicationEventPublisher; // <2>
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) { // <2>
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
