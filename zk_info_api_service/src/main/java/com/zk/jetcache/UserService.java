package com.zk.jetcache;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;

/**
 * @Author Zhangk
 * @Date 16:17 2018/11/9
 * @Description
 */
public interface UserService {
    /**
     * 接口添加@Cached  需要指定jvm参数
     * javac 添加-parameters参数
     * 实现类上可以直接使用
     * @param userId
     * @return
     *
     * To enable use parameter name such as key="#userId",
     * you javac compiler target must be 1.8 and the -parameters should be set,
     * otherwise use index to access parameters like key="args[0]"
     *
     *name = "UserService.getUserById",
     */
    @Cached(expire = 100, cacheType = CacheType.REMOTE, key = "#userId")
    User getUserById(long userId);

    User getUser(long userid);
}
