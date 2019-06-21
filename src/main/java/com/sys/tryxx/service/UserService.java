package com.sys.tryxx.service;

import com.sys.tryxx.Dao.UserRepository;
import com.sys.tryxx.domain.User;
import com.sys.tryxx.rocketmq.Consumer;
import com.sys.tryxx.rocketmq.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
//@CacheConfig(cacheNames = "lemonCache")
public class UserService {
    @Autowired
    private UserRepository userRepository;
    /*private UserRepository userRepository;//setter方法注入
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @CachePut(value = "lemonCache")
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
     *如果一级缓存存在，从Ehcache中获取信息
     * 如果一级缓存不存在，从 redis缓存 中获取信息
     * 如果都不存在 从DB中获取信息 插入缓存
     *
     * @param id 用户ID
     * @return 用户
     */
    @Cacheable(value = "lemonCache")
    public User getById(Integer id) {
        // 从缓存中获取用户信息
        String key = "user_"+id;
       /* if(ehCacheCacheManager.getCacheNames().contains(key)){
            logger.info("ehcache 缓存");
        }*/
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);
            logger.info("从redis缓存中取数据");
            return user;
        }
        // 缓存不存在，从 DB 中获取
        User user = userRepository.getUserById(id);
        logger.info("从数据库里取数据");
        // 插入缓存
        operations.set(key, user, 50, TimeUnit.SECONDS);
        return userRepository.getUserById(id);
    }

    /**
     * 更新用户
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     *
     * @param user 用户
     */
    @CachePut(value = "lemonCache")
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

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAllUsers();
        return users;
    }

    @CachePut(value = "lemonCache")
    public User updateCache(User user){
        User newUser = userRepository.getUserById(user.getId());
        int userId = user.getId();
        ValueOperations operations = redisTemplate.opsForValue();
        String key = "user_"+userId;
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            redisTemplate.delete(key);
            logger.info("旧的缓存被删除。。");
        }
        newUser.setUsername(user.getUsername());
        userRepository.updateById(newUser);
        operations.set(key,newUser,100,TimeUnit.SECONDS);
        logger.info("缓存已更改");
        //这样你看是不是就对着呢 看看哈
        return newUser;
    }
    /**
     * 用户登录
     */
    @Cacheable(value="lemonCache",key="'user_'+#username+#password")
    public String login(String username,String password){
        String key  = "user_"+username+password;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            User user = operations.get(key);
            logger.info("缓存中存在用户名和密码啦");
            return "登录中。。。";
        }

        logger.info("从数据库验证用户身份。。。");
        User user = userRepository.findUserByIdAndName(username,password);
        operations.set(key,user,100,TimeUnit.SECONDS);
        if(user!=null){
            return "登录中。。。";
        }else {
            return "用户名或密码不正确，请重新登录";
        }
    }

}