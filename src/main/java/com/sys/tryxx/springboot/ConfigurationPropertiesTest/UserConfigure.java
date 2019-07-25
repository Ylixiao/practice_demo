package com.sys.tryxx.springboot.ConfigurationPropertiesTest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: tryxx
 * @description:
 * @author: xiao
 * @create: 2019-04-24 09:56
 **/
@Component
@ConfigurationProperties(prefix = "student")
public class UserConfigure {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "UserConfigure{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}