package com.wilson.java;

public class ReverseStr344 {


    public static void main(String[] args) {
        String stre="123456";
        reverseString(stre.toCharArray());
        String s = reverseWithSwaps(stre);
        System.out.println(stre);
        System.out.println(s);



    }
    //链接：https://juejin.im/post/5ea3971b6fb9a03c64232521
    public static String reverseWithSwaps(String string) {
        final char[] array = string.toCharArray();
        final int length = array.length - 1;
        final int half = (int) Math.floor(array.length / 2);

        for (int i = length; i >= half; i--) {
            char c;
            c = array[length - i];
            array[length - i] = array[i];
            array[i] = c;
        }
        return String.valueOf(array);
    }

   // 链接：https://leetcode-cn.com/problems/reverse-string/solution/fan-zhuan-zi-fu-chuan-by-leetcode/
    //双指针法
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }



}
