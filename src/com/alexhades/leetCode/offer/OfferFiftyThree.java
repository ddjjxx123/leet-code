package com.alexhades.leetCode.offer;

import org.junit.Test;

public class OfferFiftyThree {

    @Test
    public void  fn(){
        System.out.println(search(new int[]{5,7,7,8,8,10},6));
    }

    public int search(int[] nums, int target) {
        int count=0;
        int l=0;
        int r=nums.length;
        while(l<r){
            int mid=(l+r)>>>1;
            if(nums[mid]==target){
                int last=mid-1;
                int next=mid+1;
                count++;
                while(last>=0&& nums[last]==target){
                    count++;
                    last--;
                }
                while(next<nums.length && nums[next]==target){
                    count++;
                    next++;
                }
                break;
            }else if(nums[mid]<target){
                l=mid+1;
            }else {
                r=mid;
            }


        }
        return count;
    }
}
