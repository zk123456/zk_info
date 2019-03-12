package com.jdd.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author zk
 * @Date 11:43 2019/3/12
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService{
    @Override
    public User save() {
        User user = new User(1L);
        return user;
    }
}
