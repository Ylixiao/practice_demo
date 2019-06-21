package com.sys.tryxx.Offer;

public class JinZhiTransfer {
    public static int NumberOf1(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);

        char[] chars = s.toCharArray();
        for(char c:chars){
            if(c=='1'){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println( Integer.toBinaryString(-10));
    }
}
