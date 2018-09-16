package com.donkey.demo.configurer;

import com.donkey.demo.utils.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by qixin-lvxincao on 2018/3/6.
 */
@Configuration
public class RedisConfig {
    protected static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Value("${spring.redis.host}")
    private String hostName;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private int timeout;

    @Bean
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    public JedisPool getJedisPool(){
        JedisPoolConfig config = getRedisConfig();
        JedisPool pool = null;
        if(StrUtil.isBlank(password)){
            pool = new JedisPool(config,hostName,port,timeout);
        }else{
            pool = new JedisPool(config,hostName,port,timeout,password);
        }
        logger.info("init JredisPool ...");
        return pool;
    }

}
