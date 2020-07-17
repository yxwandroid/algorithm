package com.wilson.java.code;
// 反转字符串
public class ReverseStr {

    public static void main(String[] args) {
        String stre="123456";
        reverseString(stre.toCharArray());
        System.out.println(stre);

    }
    // 链接：https://leetcode-cn.com/problems/reverse-string/solution/fan-zhuan-zi-fu-chuan-by-leetcode/
    // 双指针法
    // 反转字符串
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }



}
