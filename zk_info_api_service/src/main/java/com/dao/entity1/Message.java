package com.dao.entity1;

import javax.persistence.*;

/**
 * @author zk
 * @Date 19:58 2019/3/4
 */
@Entity
@Table(name = "temp_message")
public class Message {
    private Long id;

    private String name;

    public Message(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Message() {
        super();
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
