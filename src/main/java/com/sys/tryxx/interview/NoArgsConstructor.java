package com.sys.tryxx.interview;

/**
 * @program: tryxx
 * @description: 为啥要写一个无参构造器(并不做什么事情的呀) 防止编译报错
 * @author: xiao
 * @create: 2019-06-18 17:01
 **/
public class NoArgsConstructor {

  public static void main(String[] args) {
    Dog dog = new Dog();
  }

}

class Animal {

  String name = "";

  //这句话不写就会报错  或者将子类的构造函数写super()
  public Animal() {
  }

  public Animal(String name) {
    this.name = name;
  }

}

class Dog extends Animal {

  static String name = "";

  public Dog() {
    super(name);
  }
}