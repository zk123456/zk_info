package com.service.impl;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author Zhangk
 * @Date 20:54 2019/2/25
 * @Description
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME,AGE) values (?,?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from user where name = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return null;
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from user");
    }
}
