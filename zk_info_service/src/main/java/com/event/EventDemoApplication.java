package com.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Zhangk
 * @Date 16:18 2019/2/18
 * @Description
 */
@SpringBootApplication
@RestController
public class EventDemoApplication {

    public static void main(String []args) {
        SpringApplication.run(EventDemoApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(){
        userService.register("kirito");
        return "success";
        /**
         * result:
         * 用户：kirito 已注册！
         发送短信通知，给 kirito 发送短信...
         邮件服务接到通知，给 kirito 发送邮件.
         */
    }
}
