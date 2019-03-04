package com.chapter;

import com.dto.TimeDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

/**
 * @Author Zhangk
 * @Date 14:02 2019/2/21
 * @Description
 */
@Controller
public class HelloController {

    private final static Log logger = LogFactory.getLog(HelloController.class);

    @Autowired
    private BlogProperties blogProperties;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("===================测试属性文件参数注入=====================");
        System.out.println(blogProperties.getName());
        System.out.println(blogProperties.getTitle());
        System.out.println(blogProperties.getDesc());
        System.out.println(blogProperties.getValue());
        System.out.println(blogProperties.getNumber());
        return "hello spring boot";
    }

    /**
     * Error resolving template "index", template might not exist or might not be accessible by any of the configured Template Resolvers
     * 当出现上面的错误的时候,提示这个html不存在,要不是controller返回的html文件名不对
     * 要不然就是application.properties中的spring.thymeleaf.prefix配置错误
     * @param map
     * @return
     */
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "10.33.92.35");
        return "index";
    }

    @RequestMapping("/e1")
    public String hello2() throws Exception{
        throw new Exception("发生异常了");
    }

    @RequestMapping("/time")
    @ResponseBody
    public TimeDTO getTime() {
        /**
         * 出现的异常问题:
         * 2018-03-13 09:22:58,445 WARN  [http-nio-9988-exec-3] org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver - Failed to read HTTP message: org.springframework.http.converter.HttpMessageNotReadableException:
         * JSON parse error: Can not construct instance of java.time.LocalDate: no suitable constructor found,
         * can not deserialize from Object value (missing default constructor or creator, or perhaps need to add/enable type information?); nested exception is com.fasterxml.jackson.databind.JsonMappingException:
         * Can not construct instance of java.time.LocalDate: no suitable constructor found, can not deserialize from Object value (missing default constructor or creator, or perhaps need to add/enable type information?)
         at [Source: java.io.PushbackInputStream@67064c65; line: 1, column: 63] (through reference chain: java.util.ArrayList[0]->com.didispace.UserDto["birthday"])
         */
        /**
         * http://blog.didispace.com/Spring-Boot-And-Feign-Use-localdate/
         * 记录接口请求参数或者返回结果集中含有LocalTime LocalDate LocalDateTime
         * 出现的异常问题
         *
         * 解决方案:
         * @Bean
        public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
        }

        <dependency>
        <groupId>com.fasterxml.jackson.datatype</groupId>
        <artifactId>jackson-datatype-jsr310</artifactId>
        </dependency>
         */
        TimeDTO dto = new TimeDTO();
        dto.setName("aaa");
        dto.setBirthday(LocalDate.now());
        return dto;
    }
}
