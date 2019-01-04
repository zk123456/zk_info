package com.jdd.zk;

import com.alicp.jetcache.anno.support.GlobalCacheConfig;
import com.zk.jetcache.UserService;
import com.zk.springcache.BookRep;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by Administrator on 2018/4/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appcontext/app-spring-config-info.xml")
public class BaseTest {

    @Autowired
    private BookRep bookRep;
    @Autowired
    private UserService userService;
    @Autowired
    private GlobalCacheConfig config;

    @Test
    public void test1() {
        System.out.println("test...");
    }

    @Test
    public void test2() {
        bookRep.getByIsbn("1234");
    }

    @Test

    public void test3() {
        //System.out.println(userService.getUser(1l));
        System.out.println(userService.getUserById(1l));
    }
}
