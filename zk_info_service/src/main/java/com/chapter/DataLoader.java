package com.chapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author Zhangk
 * @Date 10:45 2019/2/22
 * @Description
 */

/**
 * CommandLineRunner 主要用于在项目启动的时候 预加载一些数据,实现此接口即可
 * 项目启动的时候回遍历这些实现CommandLineRunner 接口的实例
 * 并且按照一定的顺序执行,顺序的注解是@Order(1)
 */
@Component
@Slf4j
@Order(1)
public class DataLoader implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        log.info("===============load data");
    }
}
