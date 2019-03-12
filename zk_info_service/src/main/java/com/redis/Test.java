package com.redis;

import java.io.Serializable;

/**
 * @author zk
 * @Date 16:07 2019/3/7
 */
public class Test implements Serializable{
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public Test() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
