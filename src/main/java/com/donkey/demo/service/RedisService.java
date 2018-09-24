package com.donkey.demo.service;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by qixin-lvxincao on 2018/7/18.
 */
public interface RedisService {

    /**
     * 获取资源
     * @return
     * @throws redis.clients.jedis.exceptions.JedisException
     */
    Jedis getResource();

    /**
     * 释放资源
     * @param jedis
     */
    void returnResource(Jedis jedis);

    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    String set(String key, String value, int cacheSeconds);

    /**
     * 获得分布式锁
     * @param lockKey
     * @param value
     * @param expireTime
     * @return
     */
    boolean getDistributedLock(String lockKey, String value, int expireTime);

    /**
     * 获取缓存
     * @param key 键
     * @return 值
     */
    String get(String key);

    /**
     * 缓存是否存在
     * @param key 键
     * @return
     */
    boolean exists(String key);

    /**
     * 删除缓存
     * @param key 键
     * @return
     */
    long del(String key);

    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    String setObject(String key, Object value, int cacheSeconds);

    /**
     * 获取缓存
     * @param key 键
     * @return 值
     */
    Object getObject(String key);


    /**
     * 缓存是否存在
     * @param key
     * @return
     */
    boolean existsObject(String key);


    /**
     * 删除缓存
     * @param key 键
     * @return
     */
    long delObject(String key);

    /**
     * 设置List缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    long setList(String key, List<String> value, int cacheSeconds);

    /**
     * 获取List缓存
     * @param key 键
     * @return 值
     */
    List<String> getList(String key);

    /**
     * 向List缓存中添加值
     * @param key 键
     * @param value 值
     * @return
     */
    long listAdd(String key, String... value);

    /**
     * 设置List缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    long setObjectList(String key, List<Object> value, int cacheSeconds);

    /**
     * 获取List缓存
     * @param key 键
     * @return 值
     */
    List<Object> getObjectList(String key);

    /**
     * 向List缓存中添加值
     * @param key 键
     * @param value 值
     * @return
     */
    long listObjectAdd(String key, Object... value);


    /**
     * 向List缓存中添加值
     * @param key 键
     * @return
     */
    String listObjectDel(String key);

    boolean sisMember(String key, String value);

    /**
     * 设置Set缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    long setSet(String key, Set<String> value, int cacheSeconds);

    /**
     * 获取缓存
     * @param key 键
     * @return 值
     */
    Set<String> getSet(String key);

    /**
     * 向Set缓存中添加值
     * @param key 键
     * @param value 值
     * @return
     */
    long setSetAdd(String key, String... value);


    /**
     * 设置Set缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    long setObjectSet(String key, Set<Object> value, int cacheSeconds);

    /**
     * 获取缓存
     * @param key 键
     * @return 值
     */
    Set<Object> getObjectSet(String key);

    /**
     * 向Set缓存中添加值
     * @param key 键
     * @param value 值
     * @return
     */
    long setSetObjectAdd(String key, Object... value);

    /**
     * 设置Map缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    String setMap(String key, Map<String, String> value, int cacheSeconds);

    /**
     * 获取Map缓存
     * @param key 键
     * @return 值
     */
    Map<String, String> getMap(String key);

    /**
     * 向Map缓存中添加值
     * @param key 键
     * @param value 值
     * @return
     */
    String mapPut(String key, Map<String, String> value);

    /**
     * 移除Map缓存中的值
     * @param key 键
     * @param mapKey 值
     * @return
     */
    long mapRemove(String key, String mapKey);

    /**
     * 判断Map缓存中的Key是否存在
     * @param key 键
     * @param mapKey 值
     * @return
     */
    boolean mapExists(String key, String mapKey);

    /**
     * 设置Map缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    String setObjectMap(String key, Map<String, Object> value, int cacheSeconds);

    /**
     * 获取Map缓存
     * @param key 键
     * @return 值
     */
    Map<String, Object> getObjectMap(String key);

    /**
     * 向Map缓存中添加值
     * @param key 键
     * @param value 值
     * @return
     */
    String mapObjectPut(String key, Map<String, Object> value);

    /**
     * 移除Map缓存中的值
     * @param key 键
     * @param mapKey 值
     * @return
     */
    long mapObjectRemove(String key, String mapKey);

    /**
     * 判断Map缓存中的Key是否存在
     * @param key 键
     * @param mapKey 值
     * @return
     */
    boolean mapObjectExists(String key, String mapKey);


    /**
     * 归还资源
     * @param jedis
     */
    void returnBrokenResource(Jedis jedis);

}
