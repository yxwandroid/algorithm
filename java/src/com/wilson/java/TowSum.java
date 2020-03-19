package com.wilson.java;

import java.util.HashMap;
import java.util.Map;

//1 两数之和
//  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//  你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//  示例:
//  给定 nums = [2, 7, 11, 15], target = 9
//  因为 nums[0] + nums[1] = 2 + 7 = 9
//  所以返回 [0, 1]
public class TowSum {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //条件是一个数组   和目标数字   求和是这个数字的数组的下标
    public int[] twoSum1(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    a[0] = nums[i];
                    a[1] = nums[j];
                }

            }
        }


        return a;
    }





    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }




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
