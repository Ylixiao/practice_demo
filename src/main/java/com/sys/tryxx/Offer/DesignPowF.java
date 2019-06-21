package com.sys.tryxx.Offer;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: tryxx
 * @description:
 * @author: xiao
 * @create: 2019-04-03 17:25
 **/
@Slf4j
public class DesignPowF {

  public static void main(String[] args) {
    String url = "aa";
    if(1==1){
      log.warn(String.format("url=[%s]",url));
    }
    System.out.println(pow(2.2,-2));
  }

  public static double pow(double base, int exponent) {
    double result = 0;
    if (base == 0) {
      return 0;
    } else if (exponent == 0) {
      return 1;
    } else if (exponent > 0) {
      result =  multiply(base, exponent);
    } else if (exponent < 0) {
      result =  multiply(1 / base, -exponent);
    }
    return result;
  }

  private static double multiply(double base, int exponent) {
    double sum = 1;
    for (int i = 0; i < exponent; i++) {
      sum = sum * base;
    }
    return sum;
  }
}