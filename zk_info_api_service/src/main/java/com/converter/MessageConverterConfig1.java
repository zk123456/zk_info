package com.converter;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author Zhangk
 * @Date 20:28 2019/2/25
 * @Description
 */

/**
 * spring boot新版本替换WebMvcConfigurerAdapter   使用WebMvcConfigurer接口
 */

/**
 * 实现xml格式数据在springboot中只需要引入jackson-dataformat-xml即可
 * 引入之后springboot会自动引入MappingJackson2XmlHttpMessageConverter
 */
//@Configuration
public class MessageConverterConfig1 implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = Jackson2ObjectMapperBuilder.xml();
        builder.indentOutput(true);
        converters.add(new MappingJackson2XmlHttpMessageConverter(builder.build()));
    }
}
