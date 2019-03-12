package com.jdd.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author zk
 * @Date 15:25 2019/3/12
 */
@Component
public class UserConsumer {

    @Reference(version = "1.0.0")
    UserService userService;

    public void save() {
        User save = userService.save();
        System.out.println(save);
    }

}
