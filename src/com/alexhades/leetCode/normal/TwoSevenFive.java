package com.alexhades.leetCode.normal;

public class TwoSevenFive {

    public int hIndex(int[] citations) {
        int l = citations.length;
        int left = 0;
        int right = l-1;
        if(citations[l-1]==0){
            return 0;
        }
        while(right>left){
            int mid=(right+left)/2;
            if(citations[mid]<(l-mid)){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return l-left;
    }
}
