package com.fc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类，需要依赖Spring环境
 */
@Configuration
public class RedisUtils {
    // 从容器中获取模板对象
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    // 从容器中获取Lettuce连接池对象
    @Autowired
    private LettuceConnectionFactory factory;

    @PostConstruct
    public void init() {
        // 设置客户端连接工厂
        redisTemplate.setConnectionFactory(factory);

        // 进行模板对象的初始化操作
        redisTemplate.afterPropertiesSet();

        // 创建序列化对象
        RedisSerializer<Object> redisSerializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // 设置键、值，哈希中的键、值的序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(redisSerializer);
    }

    /**
     * 设置String类型的键值对
     * @param key 键
     * @param value 值
     */
    public void set(Object key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 相当于setex
     *
     * @param key 键
     * @param value 值
     * @param expire 过期时间(单位是秒)
     */
    public void set(Object key, Object value, Integer expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    /**
     * 根据键获取对应的值
     * @param key 键
     * * @return 值
     */
    public Object get(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 根据模板删除，相当于keys *并且删除
     * @param key 键
     */
    public void delByPattern(Object key) {
        Set<Object> keys = redisTemplate.keys("*" + key + "*");

        if (keys != null) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 根据指定的键进行删除
     * @param key 键
     */
    public void del(Object key) {
        redisTemplate.delete(key);
    }

    /**
     * 设置hash类型的键值对
     * @param key 键
     * @param hashKey 字段
     * @param value 值
     */
    public void hSet(Object key, Object hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * 设置hash类型的键值对
     * @param key 键
     * @param map 键值对
     */
    public void hSet(Object key, Map<Object, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);

    }

    /**
     * 根据键以及字段获取对应的值
     * @param key 键
     * @param hashKey 字段
     * @return 值
     */
    public Object hGet(Object key, Object hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * 获取指定模板的key的个数
     * @param key 键
     * @return 键的数量
     */
    public int size(Object key) {
        Set<Object> keys = redisTemplate.keys("*" + key + "*");

        if (keys != null) {
            return keys.size();
        }

        return 0;
    }
}
