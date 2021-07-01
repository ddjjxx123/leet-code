package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FourZeroOne {

    int[] H=new int[]{8,4,2,1};
    int[] M=new int[]{32,16,8,4,2,1};
    @Test
    public void fn1(){
        print(readBinaryWatch(1));
    }

    private void print(List<String> list) {
       list.forEach(System.out::println);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res=new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j <60 ; j++) {
                if(Integer.bitCount(i)+Integer.bitCount(j)==turnedOn){
                    res.add(i+":"+ (j>10?j:("0"+j)));
                }
            }
        }
        return res;
    }
}
