package com.dto;

import java.time.LocalDate;

/**
 * @Author Zhangk
 * @Date 19:47 2019/2/25
 * @Description
 */
public class TimeDTO {
    private String name;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
