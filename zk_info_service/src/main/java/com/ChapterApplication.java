package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Author Zhangk
 * @Date 11:13 2019/2/21
 * @Description
 */
@SpringBootApplication
public class ChapterApplication {
    /**
     * 一些事件的执行顺序和时间点
     * 2019-02-22 10:46:27.938  INFO 18140 --- [ main] e.ApplicationStartedEventListener   : ======================applicationStartedEvent
     2019-02-22 10:46:27.939  INFO 18140 --- [ main] DataLoader      : ===============load data
     2019-02-22 10:46:27.939  INFO 18140 --- [main] e.ApplicationReadyEventListener  : ==========================applicationReadyEvent
     * @param args
     */
    public static void main(String[] args) {
        //SpringApplication.run(ChapterApplication.class, args);


        ApplicationContext context = SpringApplication.run(ChapterApplication.class, args);

        /*Binder binder = Binder.get(context.getEnvironment());
        // 绑定List配置
        List<String> title = binder.bind("spring.database.title", Bindable.listOf(String.class)).get();
        System.out.println("==================bind=================");
        System.out.println(title);

        List<Info> infos = binder.bind("spring.database.info", Bindable.listOf(Info.class)).get();
        System.out.println(infos);*/
    }
}
