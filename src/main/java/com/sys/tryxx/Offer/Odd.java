package com.sys.tryxx.Offer;

public class Odd {
    public void reOrderArray(int [] array) {
        int[] array2 = new int[array.length];
        int j=0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0){
                array2[j] = array[i];
                j++;
            }
        }
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0){
                array2[j] = array[i];
                j++;
            }
        }
        for(int i=0;i<array.length;i++){
            array[i] = array2[i];
        }
    }
}
