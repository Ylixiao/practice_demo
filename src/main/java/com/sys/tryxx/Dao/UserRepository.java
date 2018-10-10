package com.sys.tryxx.Dao;

import com.sys.tryxx.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User getUserById(Integer id);
    User getUserByName(String username);
    void  addUser(User user);
    User findUserByIdAndName(String username, String password);
    void updateById(User user);

}
