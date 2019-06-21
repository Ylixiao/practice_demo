package com.sys.tryxx.Controller;

import java.lang.reflect.Method;
import org.springframework.stereotype.Component;

/**
 * @program: tryxx
 * @description:
 * @author: xiao
 * @create: 2019-05-05 11:59
 **/
@Component
public class ReflectBean {
  public Class get(Object message){
    Class classes = message.getClass();
    return classes;
  }
}