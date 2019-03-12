package com.test;

import com.ChapterApplication;
import com.dao.entity1.Message;
import com.dao.repo1.MessageRepository;
import com.dao.repo.UserRepository;
import com.dao.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Zhangk
 * @Date 14:32 2019/2/21
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
/**
 * SpringApplicationConfiguration 1.*的版本有这个注解  之后新的版本去掉了
 * 用SpringBootTest 代替
 */
@SpringBootTest(classes = ChapterApplication.class)
public class Chapter3ApplicationTest {

    /**
     * spring-data-jpa操作方式
     */
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    /**
     * jdbctemplate操作方式
     */
    @Qualifier("primaryJdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate1;
    @Qualifier("secondaryJdbcTemplate")
    @Autowired
    private JdbcTemplate jdbcTemplate2;

    /**
     * 缓存管理
     */
    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test4() {
        userRepository.save(new User(20L, "eeeee"));
    }

    @Test
    public void test5() {
        User eeeee = userRepository.findByName("e");
        System.out.println("1-------------------" + eeeee.getName());

        User eeeee1 = userRepository.findByName("e");
        System.out.println("2------------------" + eeeee1.getName());

        Cache users = cacheManager.getCache("users");
        System.out.println();
    }

    @Transactional
    @Test
    public void test() {
        /**&
         * 在Spring Boot中，当我们使用了spring-boot-starter-jdbc或spring-boot-starter-data-jpa依赖的时候，
         * 框架会自动默认分别注入DataSourceTransactionManager或JpaTransactionManager。
         * 所以我们不需要任何额外配置就可以用@Transactional注解进行事务的使用
         *
         * SpringBoot 集成 atomikos 实现分布式事务
         *
         * @Transactional(value="transactionManagerPrimary")多事务管理器配置
         * @Transactional(isolation = Isolation.DEFAULT)
         * @Transactional(propagation = Propagation.REQUIRED)
         */
        //userRepository.save(new User(3L, "3"));
        //userRepository.save(new User(4L, "4"));

        /**
         * error:Caused by: com.mysql.jdbc.MysqlDataTruncation: Data truncation: Data too long for column 'name' at row 1
         * 在出现上述错误的情况下,错误代码上面的事务都已经提交
         * 要使这些操作在一个事务里面执行 就需要添加@Transactional
         */
        /**
         * spring-data-jpa发现一个问题:像下面重复的主键,也可以执行,不会报错
         */
        userRepository.save(new User("123"));
        userRepository.save(new User(1L, "123"));
        //userRepository.save(new User("asdfasdfasdfasdfasd"));
        /*User byName = userRepository.findByName("3");
        System.out.println(byName.getId() + "====" + byName.getName());

        User user = userRepository.findUser("2");
        System.out.println(user.getId() + "====" + user.getName());*/
    }

    @Test
    public void test3() {
        jdbcTemplate1.update("insert into temp_user(id, name) values(?, ?)", 6, "6");
        jdbcTemplate2.update("insert into temp_user(id, name) values(?, ?)", 1, "1");
    }

    @Test
    public void testMultiDataSourceJpa() {
        /**
         * spring-data-jpa多数据源配置问题
         * 在配置类中配置的扫描repository的路径以及实体的路径的时候
         * 需要在不同的目录下扫描,否则回出现错误
         */
        userRepository.save(new User(10L, "10"));
        messageRepository.save(new Message(1L, "1"));
    }
}
