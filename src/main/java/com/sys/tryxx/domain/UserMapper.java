package com.sys.tryxx.domain;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

      /*  @Select("SELECT * FROM user WHERE id = #{id}")
        User findUserById(@Param("id") Integer id);

        @Insert("INSERT INTO user(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
        int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);*/
       User findUserById(Integer id);
       User findUserByName(String username);
       void addUser(User user);
       void updateById(User user);
       User findUserByIdAndName(@Param("username") String username, @Param("password") String password);
       List<User> findAllUsers();
}

