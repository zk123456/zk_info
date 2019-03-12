package com.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Zhangk
 * @Date 20:36 2019/2/25
 * @Description
 */
@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "Student")
public class Student {
    @JacksonXmlProperty(localName = "age")
    private int age;
    @JacksonXmlProperty(localName = "name")
    private String name;

}
