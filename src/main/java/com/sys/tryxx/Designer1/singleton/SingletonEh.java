package com.sys.tryxx.Designer1.singleton;

/**
 * @program: tryxx
 * @description: 单例模式-饿汉式
 * @author: xiao
 * @create: 2019-06-12 18:53
 **/
public class SingletonEh {
  private static SingletonEh singletonEH = new SingletonEh();
  private SingletonEh(){}
  public SingletonEh getInstance() {
    return singletonEH;
  }
}