package com.sys.tryxx.springboot.condition;


import lombok.extern.slf4j.Slf4j;

/**
 * @program: tryxx
 * @description: 实现类
 * @author: xiao
 * @create: 2019-04-25 10:39
 **/
@Slf4j
public class ConditionalOne implements ConditionalAnnotation {

  @Override
  public void init() {

  }

  @Override
  public void destroy() {

  }

  @Override
  public boolean sendmessage(String topic,String tag,String message) {
    log.info("第一个实现类》》{}",message);
    return true;
  }
}