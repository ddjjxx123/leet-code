package com.alexhades.leetCode.normal;

import org.junit.Test;

public class OneSixEight {
    @Test
    public void fn(){
        System.out.println(convertToTitle(2147483647));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder=new StringBuilder();
        while(columnNumber>0){

            stringBuilder.insert(0,(char) ((columnNumber-1)%26+'A'));
            columnNumber=(columnNumber-1)/26;
        }
        return stringBuilder.toString();

    }
}
