package com.sys.tryxx.Offer;

public class FragPlus {
    public int sss(int target){
        int sum = 1;
        int count = 1;
        if(target==0){
            return 0;
        }
        if(target==1){
            return count;
        }
        for(int i=2;i<=target;i++){
            sum = sum*2;
        }
        return sum;
    }
}
