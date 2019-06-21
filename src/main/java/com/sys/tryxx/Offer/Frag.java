package com.sys.tryxx.Offer;
//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
//这种题一定要先找规律哟 感觉是这样的吧

public class Frag {
    public int JumpFloor(int target) {
        int first = 1;
        int last = 2;
        int result = 0;
        if(target==0){
            return target;
        }else if(target==1){
            return first;
        }else if(target ==2){
            return last;
        }else {
            for(int i=3;i<=target;i++){
                result = first+last;
                first = last;
                last = result;
        }
        return result;
        }
    }
}
