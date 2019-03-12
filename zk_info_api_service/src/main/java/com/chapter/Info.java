package com.chapter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author Zhangk
 * @Date 11:33 2019/2/22
 * @Description
 */
@Data
@ConfigurationProperties
public class Info {
    private String title;
    private String content;
}
