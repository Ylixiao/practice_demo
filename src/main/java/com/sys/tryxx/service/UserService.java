package com.sys.tryxx.service;

import com.sys.tryxx.Dao.UserRepository;
import com.sys.tryxx.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


@Service
@Transactional
@CacheConfig(cacheNames = "lemonCache")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    public String register(User user) {

        User newUser = userRepository.getUserByName(user.getUsername());
        if(newUser==null){
            userRepository.addUser(user);
            return "注册成功";
        }else {
            return "用户名已存在，请重新注册";
        }

    }

    /**
     * 获取用户信息
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     *
     * @param id 用户ID
     * @return 用户
     */
    @Cacheable
   public User getById(Integer id) {
        // 从缓存中获取用户信息
        /*String key = "user_" + id;
            ValueOperations<String, User> operations = redisTemplate.opsForValue();

            // 缓存存在
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                User user = operations.get(key);
                return user;
        }

        // 缓存不存在，从 DB 中获取
        User user = userRepository.getUserById(id);
        // 插入缓存
        operations.set(key, user, 10, TimeUnit.SECONDS);

        return user;*/
        System.out.println("没有缓存，开始查询数据库……");
        return userRepository.getUserById(id);
    }

    /**
     * 更新用户
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     *
     * @param user 用户
     */
    public void updateUser(User user) {
        userRepository.updateById(user);
        int userId = user.getId();
        // 缓存存在，删除缓存
        String key = "user_" + userId;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 用户登录
     */
    public String login(String username,String password){
        User user = userRepository.findUserByIdAndName(username,password);
        if(user!=null){
            return "登录中。。。";
        }else {
            return "用户名或密码不正确，请重新登录";
        }
    }

}
