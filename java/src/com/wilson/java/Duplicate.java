package com.wilson.java;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 *
 * 要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 *
 * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
 *
 * 以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复：
 */
public class Duplicate {


    public static void main(String arg[]) {
        int[] nums = {2, 3, 1, 0, 2, 5};
        int length = 6;
        int[] duplication = new int[6];
        duplicate(nums, length, duplication);
        System.out.print(duplication[0]);
    }


    // 利用HashSet特性   当元素存储的时候返回的是false
    //https://www.bilibili.com/video/BV1ZK4y1b7Xn?from=search&seid=16437830322922198493
//    private static void duplicate(int[] nums, int length, int[] duplication) {
//        if (nums==null||length<=0)
//            return;
//
//        Set<Integer> objects = new HashSet<Integer>();
//
//        for (int i = 0; i <length ; i++) {
//            int num = nums[i];
//            if (!objects.add(num)){
//                duplication[0]= num;
//                return;
//            }
//        }
//    }


    //方式1 根据调整i 位置上的值 i  若i位置上已经有i值了就说明已经存在重复元素了
    //https://github.com/CyC2018/CS-Notes/blob/master/notes/3.%20%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97.md
    public static boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) { //for 循环目的是能遍历到所有的元素
            while (nums[i] != i) {  //当i位置上的值不是i的时候才进行数据交换

                //对应i位置上的值若等于 对应值对应的的元素的值的时候说明值相等
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }

                System.out.println(i + "----");
                swap(nums, i, nums[i]); //进行交互的代码
            }
            System.out.println(i);
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
