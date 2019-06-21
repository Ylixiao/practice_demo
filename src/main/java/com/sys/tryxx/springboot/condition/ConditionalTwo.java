package com.sys.tryxx.springboot.condition;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: tryxx
 * @description: 实现类2
 * @author: xiao
 * @create: 2019-04-25 10:42
 **/
@Slf4j
public class ConditionalTwo implements ConditionalAnnotation {

  @Override
  public void init() {

  }

  @Override
  public void destroy() {

  }

  @Override
  public boolean sendmessage(String topic,String tag,String message) {
    log.info("第二个实现类》》{}",message);
    return true;
  }
}