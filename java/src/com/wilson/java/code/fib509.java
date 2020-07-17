package com.wilson.java.code;
//斐波那契数
public class fib509 {

    public static void main(String[] args) {
        int fib = fib(7);

        System.out.println(fib);
        int fibonacci = fibonacci(7);
        System.out.println(fibonacci);

    }


    //递归方式
    //https://leetcode-cn.com/problems/fibonacci-number/solution/fei-bo-na-qi-shu-by-leetcode/
    public static int fib(int n) {
        if (n <= 1)
            return n;
        int sum = fib(n-1)+fib(n-2);
        return sum;
    }

// 链接：https://juejin.im/post/5ea3971b6fb9a03c64232521
    //思路for循环解法
    public static  int fibonacci(int n) {
        int[] res = {0, 1};
        if (n < 2) {
            return res[n];
        }
        int first = 0;
        int second = 1;

        int fibn = 0;

        for (int i = 2; i <= n; i++) {

            fibn = first + second;

            first = second;

            second = fibn;
        }
        return fibn;
    }


}
