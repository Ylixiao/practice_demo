package com.sys.tryxx.Offer;
//        大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
//offer说递归效率低 那我们就用循环试试
public class Fibonacci {
    public int Fibonacci(int n) {
        if(n==1||n==2) {
            return 1;
        }else if(n==0){
            return 0;
        }
        else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }

    public int Fibonacci2(int n) {
        int last = 1;
        int sum = 0;
        int first = 0;
        if(n==1) {
            return last;
        }else if(n==0) {
            return first;
        }
        for(int i=2;i<n;i++){
            sum = first+last;
            last = first;
            first = sum;
        }
        return sum;
    }

}
