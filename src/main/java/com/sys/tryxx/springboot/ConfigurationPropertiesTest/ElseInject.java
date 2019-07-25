package com.sys.tryxx.springboot.ConfigurationPropertiesTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @program: tryxx
 * @description:  默认属性配置从application.properties/application.yml文件中获取，也可以通过@PropertySource指定。
 * @author: xiao
 * @create: 2019-04-24 16:39
 **/
@Configuration
public class ElseInject {

  @Value("${student.name}")
  private String gender;


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}