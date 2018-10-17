package com.sys.tryxx.config;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

public class AppCacheManager implements CacheManager {

    public static Logger logger = LoggerFactory.getLogger(AppCacheManager.class);


    private CacheManager redisCacheManager;
    private CacheManager ehCacheManager;

    private final static String redisPrefix = "redis";

    @Override
    public Cache getCache(String name) {
        if(name.startsWith(redisPrefix)){
            return redisCacheManager.getCache(name);
        }else {
            return ehCacheManager.getCache(name);
        }

    }

    @Override
    public Collection<String> getCacheNames() {
        Collection<String> cacheNames  = new ArrayList<String>();
        if(redisCacheManager!=null){
            cacheNames.addAll(redisCacheManager.getCacheNames());
        }
        if(ehCacheManager!=null){
             cacheNames.addAll(ehCacheManager.getCacheNames());
        }
        return cacheNames;
    }

    public CacheManager getRedisCacheManager() {
        return redisCacheManager;
    }

    public void setRedisCacheManager(CacheManager redisCacheManager) {
        this.redisCacheManager = redisCacheManager;
    }

    public CacheManager getEhCacheManager() {
        return ehCacheManager;
    }

    public void setEhCacheManager(CacheManager ehCacheManager) {
        this.ehCacheManager = ehCacheManager;
    }
}


