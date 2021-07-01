package com.alexhades.leetCode.offer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class OfferThirtyEight {

    @Test
    public void fnP() {
        print(permutation("aab"));
    }

    public String[] permutation(String s) {
        Set<String> set=new HashSet<>();
        boolean[] b=new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String temp="";
            b[i]=true;
            dfs(set,b,s,temp+s.charAt(i));
            b[i]=false;
        }

        return  set.toArray(new String[0]);
    }


    public void dfs(Set<String> set, boolean[] b,String s,String temp){
        if(temp.length()==s.length()){
            set.add(temp);
            temp="";
            return;
        }
        for (int i = 0; i <s.length() ; i++) {

            if(b[i]){continue;}
            b[i]=true;
            dfs(set,b,s,temp+s.charAt(i));
            b[i]=false;
        }
    }

    public void print(String[] s) {
        for (String str : s
        ) {
            System.out.println(str);
        }
    }
}
