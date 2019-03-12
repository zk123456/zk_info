package com.dao.repo;

import com.dao.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * data jpa
 * 每个dao里面会含有很多重复的sql语句
 * 1.抽象一个统一的dao模型,每个dao实现去继承这个抽象dao
 * 2.使用spring data jpa,把dao设计成一个接口,并且不需要写这个接口的实现类,既可以调用
 *      业务dao实现JpaRepository就可以了
 *      application.properties配置datasource即可
 */
@CacheConfig(cacheNames = "users")
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    /**
     * 通过解析方法名创建查询
     * @param name
     * @return
     */
    @Cacheable
    User findByName(String name);

    /**
     * 也可以使用JPQL 创建查询条件
     * 类似与hql
     * @param name
     * @return
     */
    @Query("from User u where u.name = :name")
    User findUser(@Param("name") String name);
}
