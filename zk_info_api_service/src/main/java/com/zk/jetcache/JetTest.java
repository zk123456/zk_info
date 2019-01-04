package com.zk.jetcache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;

/**
 * @Author Zhangk
 * @Date 15:41 2018/11/9
 * @Description
 */
public class JetTest {

    @CreateCache(expire = 100)
    private static Cache<Long,User> userCache;

    public static void main(String []args) {

        UserService service = new UserServiceImpl();
        User userById = service.getUserById(1);
        System.out.println(userById.getName());
        userCache.put(userById.getId(), userById);
        System.out.println(userCache.get(1L));
    }
}
