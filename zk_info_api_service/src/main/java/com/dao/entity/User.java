package com.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Zhangk
 * @Date 16:06 2019/2/28
 * @Description
 */
@Entity
@Table(name = "temp_user")
public class User implements Serializable{

    private Long id;

    private String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
        super();
    }

    public User(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
