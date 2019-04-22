package com.sys.tryxx.practiceJava8;

import java.util.Arrays;
import java.util.List;

/**
 * 函数式编程  lambda表达式
 */
@FunctionalInterface
public interface FunctionalInter {
    //public  void run();
    public int add(int a,int b);
}

class workeree{
    public static int execute(FunctionalInter functionalInter){
        int a=8,b=7;
        return functionalInter.add(a,b);
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("试试匿名内部类");
            }
        }).start();
        new Thread(()-> System.out.println("那lambda表达式呢")).start();//不要忘记start()哟

        execute(new FunctionalInter() {
            @Override
            public int add(int a, int b) {
                System.out.println(a+b);
                return a+b;
            }
        });
        execute((int c,int d)->{
            System.out.println(c-d);
            return c-d;});
        List<Integer> list = Arrays.asList(1,3,53,5,6,7,8);
        Integer integer = list.stream().map((x) -> x * x).reduce((x,y) -> x + y).get();
        System.out.println(integer);
    }

}
