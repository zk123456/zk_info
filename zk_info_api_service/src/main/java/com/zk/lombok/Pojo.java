package com.zk.lombok;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Author Zhangk
 * @Date 15:11 2018/11/7
 * @Description
 */

/**
 * setter set方法
 * getter get 方法
 * toString toString方法
 * Accessors 允许set的时候可以使用链的方式set
 * Builder模式(使用了此注解,就不能通过new创建对象了)
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)
//@Builder
public class Pojo {
    @NonNull
    private Integer age;
    private String name;
}
