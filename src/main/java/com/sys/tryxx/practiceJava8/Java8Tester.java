package com.sys.tryxx.practiceJava8;

import com.sys.tryxx.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Java8Tester {

    public static void main(String[] args) {
        Java8Tester tester = new Java8Tester();

        MathOperation addition = (int a,int b)->a+b;
        MathOperation subtraction = (a,b)->a-b;
        MathOperation multiplication = (int a,int b)->{return a*b;};
        MathOperation division = (int a,int b)->a/b;
        System.out.println("10+5 = "+tester.operate(10,5,addition));


        GreetingService greetingService = message-> System.out.println("hello"+message);
        GreetingService greetingService1 = message -> System.out.println("hello33"+message);
        greetingService.setMessage("aa");
        greetingService1.setMessage("aabb");

        List lists = new ArrayList<>();
        lists.add( "a");
        lists.add( "aa");
        lists.add( "aaa");

        //lists.forEach(list-> System.out.println(list));
        //静态方法引用 和上面的功能是一样的
        lists.forEach(System.out::println);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a,b);
    }


    interface MathOperation {
         int operation(int a,int b);
     }

     interface GreetingService{
        void setMessage(String message);
     }

}
