package com.sys.tryxx.springboot.condition;

/**
 * @program: tryxx
 * @description: 条件相关的注解
 * @author: xiao
 * @create: 2019-04-25 10:37
 **/
public interface ConditionalAnnotation {

  void init();
  void destroy();
  boolean sendmessage(String topic,String tag,String message);

}