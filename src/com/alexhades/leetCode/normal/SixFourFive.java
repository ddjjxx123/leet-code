package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.Arrays;

public class SixFourFive {
    @Test
    public void fn() {
        int[] res = findErrorNums(new int[]{3,2,2});
        for (int i : res) {
            System.out.println(i);
        }

    }    //2 <= nums.length <= 104

    //1 <= nums[i] <= 104
    public int[] findErrorNums(int[] nums) {

        int[] res=new int[2];
        int l=nums.length;
        boolean[] used=new boolean[l+1];
        for (int i = 0; i < l; i++) {
            if(used[nums[i]]){
                res[0]=nums[i];
            }else{
                used[nums[i]]=true;
            }
        }
        for (int i = 1; i <used.length ; i++) {
            if(!used[i]){
                res[1]=i;
                break;
            }
        }
        return res;
    }
}
