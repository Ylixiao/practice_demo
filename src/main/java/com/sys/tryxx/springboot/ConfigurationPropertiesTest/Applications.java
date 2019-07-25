package com.sys.tryxx.springboot.ConfigurationPropertiesTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: tryxx
 * @description: UserConfigure 使用了@ConfigurationProperties 把配置信息封成了一个bean
 * @author: xiao
 * @create: 2019-04-24 14:46
 **/
@SpringBootApplication
@Slf4j
public class Applications implements CommandLineRunner {
  @Autowired
  public UserConfigure userConfigure;

//  @Bean
//  public ElseInject elseInject() {
//    return new ElseInject();
//  }
  @Autowired
  public ElseInject elseInject;


  public static void main(String[] args) {
    SpringApplication.run(Applications.class);
  }
  @Override
  public void run(String... args) throws Exception {
    log.info("从配置文件获取来的名字={} 和年龄={}",userConfigure.getName(),elseInject.getGender());
  }
}