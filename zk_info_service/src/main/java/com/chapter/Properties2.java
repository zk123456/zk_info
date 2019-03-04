package com.chapter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author Zhangk
 * @Date 10:53 2019/2/22
 * @Description
 */
@Component
@Data
@ConfigurationProperties(prefix = "spring.database")
public class Properties2 {
    private String name;
    private String desc;
    private List<String> title;
    private List<Info> info;
}
