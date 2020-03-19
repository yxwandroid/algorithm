package com.wilson.java;

import java.util.HashMap;

public class LongestPalindRome {
    //最长回文数算法
    public int longestPalindrome(String s) {

        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i< n; i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int res = 0;
        for(Character key: map.keySet()){
            Integer val = map.get(key);
            if((val & 1) == 1)
            {
                res+=val-1;
            } else {
                res+=val;
            }

        }
        if(res < n) {
            return res+1;
        }else{
            return res;
        }
    }
}
