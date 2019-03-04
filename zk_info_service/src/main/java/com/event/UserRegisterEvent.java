package com.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author Zhangk
 * @Date 16:22 2019/2/18
 * @Description
 */
public class UserRegisterEvent extends ApplicationEvent{
    public UserRegisterEvent(String name) { //name即source
        super(name);
    }
}
