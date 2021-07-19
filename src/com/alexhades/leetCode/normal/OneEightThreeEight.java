package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.Arrays;

public class OneEightThreeEight {
    @Test
    public void fn(){
        System.out.println(maxFrequency(new int[]{1,2,4},5));
    }

    public int maxFrequency(int[] nums, int k) {
        //滑动串口
        Arrays.sort(nums);
        // [l,r]  当 r-l 的差值* 数量大于 目标K，左游标右移，小于则 右游标右移
        int l=0,length=nums.length,res=0;
        long total=0;
        for (int r = 1; r <length ; r++) {
            total+=(long) (nums[r]-nums[r-1])*(r-l) ;
            while(total>k){
                total -= nums[r]-nums[l];
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}
