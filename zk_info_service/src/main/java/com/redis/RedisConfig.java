package com.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author zk
 * @Date 16:08 2019/3/7
 */
@Configuration
public class RedisConfig {
    /**
     * @Import 通过导入的方式实现把实例加入springIOC容器中
     * @EnableConfigurationProperties  把属性文件的值注入到类上
     *@ConditionalOnClass({RedisOperations.class})  实现自动配置的重要支撑之一
     *          判断当前classpath下是否存在指定类,若是将当前的配置加载到spring容器
     */

    /*@Bean
    @ConfigurationProperties(prefix="spring.redis")
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    public JedisConnectionFactory getConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        logger.info("JedisConnectionFactory bean init success.");
        return factory;
    }*/
    /**
     * LettuceConnectionFactory 默认实现的是这个工厂
     * 注入的实例也是这个
     * @param redisConnectionFactory
     * @return
     */
    /**
     * SpringBoot自动帮我们在容器中生成了一个RedisTemplate和一个StringRedisTemplate
     * 自动配置的类为RedisAutoConfiguration
     * 如果spring容器里面已经有RedisTemplate 实例了,springboot自动配置的RedisTemplate就不会生效了
     * 注入的工厂类是在LettuceConnectionConfiguration这个配置中创建的
     *同时   JedisConnectionConfiguration 这个配置类也会初始化JedisConnectionFactory
     * 初始化的条件都是在RedisAutoConfiguration 这个配置类中加载到的
     *
     * 当前创建的redisTemplate 会覆盖掉springboot自动配置的RedisTemplate
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, Test> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Test> template = new RedisTemplate();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate1(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
