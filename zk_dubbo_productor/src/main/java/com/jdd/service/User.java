package com.jdd.service;

import java.io.Serializable;

/**
 * @author zk
 * @Date 11:43 2019/3/12
 */
public class User implements Serializable{
    private Long id;

    public User(Long id) {
        this.id = id;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
