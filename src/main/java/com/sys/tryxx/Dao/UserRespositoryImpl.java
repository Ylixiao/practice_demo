package com.sys.tryxx.Dao;

import com.sys.tryxx.domain.User;
import com.sys.tryxx.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRespositoryImpl implements UserRepository {

    private final UserMapper userMapper;

    @Autowired
    public UserRespositoryImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public User getUserById(Integer id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @Override
    public User findUserByIdAndName(String username, String password) {
        return userMapper.findUserByIdAndName(username,password);
    }
}
