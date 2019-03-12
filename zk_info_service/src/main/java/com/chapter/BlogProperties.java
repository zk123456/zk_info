package com.chapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author Zhangk
 * @Date 14:09 2019/2/21
 * @Description
 */
@Component
@PropertySource(value = "application.properties", ignoreResourceNotFound = true,encoding = "UTF-8" )
public class BlogProperties {
    /**
     * 属性文件从resource中加载
     * 通过value属性注入
     */
    @Value("${com.didispace.blog.name}")
    private String name;
    @Value("${com.didispace.blog.title}")
    private String title;
    @Value("${com.didispace.blog.desc}")
    private String desc;

    @Value("${com.didispace.blog.value}")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
