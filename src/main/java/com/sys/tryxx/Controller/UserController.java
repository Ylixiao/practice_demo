package com.sys.tryxx.Controller;


import com.sys.tryxx.domain.User;
import com.sys.tryxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String register(User user) {
        return userService.register(user);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String login(String username, String password){
        return userService.login(username,password);
    }

    /**
     * 2018.10.16
     * @param user
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public User aa(User user){
        return userService.updateCache(user);
    }
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}