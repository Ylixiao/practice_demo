package com.sys.tryxx.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheManagerUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfig{
    public static Logger logger = LoggerFactory.getLogger(CacheConfig.class);

    @Value("classpath:/ehcache.xml")
    private Resource ehcacheConfig;

    @Bean
    RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory);
        return builder.build();
    }

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,Object> template = new RedisTemplate<String,Object>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        return template;
    }

    @Bean
    @ConditionalOnMissingBean//Spring 中是否缺少对应的实例
    public net.sf.ehcache.CacheManager innerEhCacheCacheManager(){
        Resource location = ehcacheConfig;
        if(location!=null){
            return EhCacheManagerUtils.buildCacheManager(location);
        }
        return EhCacheManagerUtils.buildCacheManager();
    }

    @Bean
    @ConditionalOnMissingBean
    public EhCacheCacheManager ehCacheCacheManager(net.sf.ehcache.CacheManager innerEhCacheCacheManager){
        return new EhCacheCacheManager(innerEhCacheCacheManager);
    }

    /**
     * Primary 是对于AppCaCheManager里面的这两个方法来注解的 不然会报错  没有一个主要的被标记的Bean
     * 这里是不是哪个manager传进来有值，就用哪个了
     * @param redisCacheManager
     * @param ehCacheCacheManager
     * @return
     */
    @Bean("cacheManager")
    @Primary
    public CacheManager cacheManager(RedisCacheManager redisCacheManager, EhCacheCacheManager ehCacheCacheManager) {
        AppCacheManager cacheManager = new AppCacheManager();
        cacheManager.setRedisCacheManager(redisCacheManager);
        cacheManager.setEhCacheManager(ehCacheCacheManager);
        return cacheManager;
    }




}