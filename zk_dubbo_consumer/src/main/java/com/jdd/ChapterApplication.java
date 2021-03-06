package com.jdd;

import com.jdd.service.UserConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Zhangk
 * @Date 11:13 2019/2/21
 * @Description
 */
@SpringBootApplication
public class ChapterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ChapterApplication.class, args);

        UserConsumer cityService = run.getBean(UserConsumer.class);
        cityService.save();
    }
}
