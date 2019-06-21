package com.sys.tryxx.Controller;


import com.sys.tryxx.domain.User;
import com.sys.tryxx.service.UserService;
import com.sys.tryxx.springboot.condition.ConditionalAnnotation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.lang.reflect.Method;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private final ConditionalAnnotation conditionalAnnotation;
    private final ReflectBean reflectBean;

    public UserController(ConditionalAnnotation conditionalAnnotation, ReflectBean reflectBean){
        this.conditionalAnnotation = conditionalAnnotation;
        this.reflectBean = reflectBean;
    }
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String register(User user) {
        return userService.register(user);
    }

    @ApiOperation(value = "根据id查询")
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User getById(@ApiParam @PathVariable Integer id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "登录验证")
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String login(String username, String password){
        return userService.login(username,password);
    }

    /**
     * 2018.10.16
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户信息")
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public User aa(User user){
        return userService.updateCache(user);
    }

    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @ApiOperation(value = "试试配置的对不对")
    @RequestMapping(value = "/conditional",method = RequestMethod.GET)
    public boolean conditionalTest(){
        return conditionalAnnotation.sendmessage("5","4","可是可是");
    }

//    @ApiOperation(value = "检查反射机制")
//    @RequestMapping(value = "/reflection",method = RequestMethod.GET)
//    public String reflectTest(){
//        return reflectBean.get(conditionalAnnotation).getSimpleName();
//    }
    @ApiOperation(value = "检查反射机制")
    @RequestMapping(value = "/reflection",method = RequestMethod.GET)
    public void reflectTest() throws Exception{
        Method method =  reflectBean.get(conditionalAnnotation).getMethod("sendmessage",String.class,String.class,String.class);
        System.out.println(method.toString());
        //执行反射得到的实例的方法
        method.invoke(conditionalAnnotation,"aa","d","ds");
    }
}