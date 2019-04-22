package com.sys.tryxx.practiceJava8;

import java.util.Optional;

public class Java8Test2 {
    public static void main(String[] args) {
        Java8Test2 java8Test2 = new Java8Test2();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        Optional<Integer> a = Optional.ofNullable(value1);

        Optional<Integer> b = Optional.of(value2);

        System.out.println(java8Test2.sum(a,b));
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("存在否："+a.isPresent());
        System.out.println("存在否："+b.isPresent());
        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();
        return  value1 + value2;
    }
}
