package com.sys.tryxx.Designer1.singleton;

/**
 * @program: tryxx
 * @description: 单例模式-懒汉式
 * @author: xiao
 * @create: 2019-06-12 18:55
 **/
public class SingletonLh {

  private static SingletonLh singletonLh = null;

  private SingletonLh() {
  }

  public SingletonLh getInstance() {
    if (singletonLh == null) {
      singletonLh = new SingletonLh();
    }
    return singletonLh;
  }
}

//加锁的懒汉式
class SingletonLhSycn {

  private static SingletonLhSycn singletonLh = null;

  private SingletonLhSycn() {
  }

  public static synchronized SingletonLhSycn getInstance() {
    if (singletonLh == null) {
      singletonLh = new SingletonLhSycn();
    }
    return singletonLh;
  }
}