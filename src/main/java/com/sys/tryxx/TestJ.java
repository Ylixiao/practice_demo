package com.sys.tryxx;

import com.sys.tryxx.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJ {

    @Autowired
    private RedisTemplate<Object, Object> template;

    @Test
    public void contextLoads() {
      /*  User user = new User(1,"象拔蚌");
        template.opsForValue().set(user.getId()+"",user);
        //原本opsForValue()是只能操作字符串的.现在就可以操作对象了
        User result = (User) template.opsForValue().get(user.getId()+"");
        System.out.println(result.toString());*/
    }
}

