package com.wilson.java.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 二维数组中的查找
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * 思路
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。
 * 因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
 */
public class Find04 {
    public static boolean Find(int target, int[][] matrix) {
        //数组为空 或则二维数据的行为0 或则列为0 就直接return
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        //获取行长度,列长度
        int rows = matrix.length, cols = matrix[0].length;

        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }


    public static void main(String[] arg) {
        int[][] matrix = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        boolean find = Find(5, matrix);
        System.out.println(find);

//        int ss= matrix[0][0];
//       System.out.println(ss);
//       System.out.println(matrix);

    }


}


