package com.zk.jetcache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;

/**
 * @Author Zhangk
 * @Date 16:18 2018/11/9
 * @Description
 * @url https://github.com/alibaba/jetcache
 */
public class UserServiceImpl implements UserService {

    /**
     * 创建一个缓存实例
     * 需要jetCacheConfig的配置
     * CacheType.BOTH (内存+远程)
     * area:多缓存系统name
     * localLimit本地缓存数量上限 默认100
     * keyConvertor key的转换方式:KeyConvertor.FASTJSON和KeyConvertor.NONE
     * name:缓存的名称
     */
    @CreateCache(name = "UserService.getUserById", expire = 100, cacheType = CacheType.REMOTE)
    private Cache<Long, User> userCache;

    /**
     * createcache注解和cached注解的name属性相同，就会得到同一个cache
     * @param userId
     * @return
     */
    //@Cached(expire = 100, cacheType = CacheType.BOTH, key = "#userId")
    @Override
    public User getUserById(long userId) {
        User user = new User();
        user.setAge(1);
        user.setId(1L);
        user.setName("1");
        return user;
    }

    @Override
    public User getUser(long userid) {
        if(userCache != null) {
            User user = userCache.get(userid);
            if(user != null) {
                System.out.println("从缓存中获取数据...................");
                return user;
            }
        }
        User userById = getUserById(userid);
        /**
         * put的时候需要key value都实现序列化
         */
        userCache.put(userid, userById);
        return userById;
    }
}
