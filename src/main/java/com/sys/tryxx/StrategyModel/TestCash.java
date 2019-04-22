package com.sys.tryxx.StrategyModel;

import java.util.Scanner;

public class TestCash {
    public static void main(String[] args) {
        System.out.println("请输入活动代码：");
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        CashContext cs = new CashContext(type);
        System.out.println(cs.getTotal(500));
    }
}
