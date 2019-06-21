package com.sys.tryxx.springboot.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: tryxx
 * @description: 条件配置
 * @author: xiao
 * @create: 2019-04-25 10:46
 **/
@Configuration
public class ConditionalConfigure {

  @Bean(initMethod = "init", destroyMethod = "destroy")
  @ConditionalOnProperty(name = "teacher.age",matchIfMissing = false)
  public ConditionalAnnotation conOne(){
    return new ConditionalOne();
  }


  @Bean(initMethod = "init", destroyMethod = "destroy")
  @ConditionalOnProperty(value = "teacher.gender",havingValue = "male")
  public ConditionalAnnotation conTwo(){
    return new ConditionalTwo();
  }
}