package com.sys.tryxx.Controller;


import com.sys.tryxx.domain.User;
import com.sys.tryxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/register")
    public String register(User user) {
        return userService.register(user);
    }

    @RequestMapping("/getById/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @RequestMapping("/login")
    public String login(String username, String password){
        return userService.login(username,password);
    }
}