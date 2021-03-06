package com.wilson.java;

//排序算法
public class SortAlgorithm {


    //外层循环控制次数 内层循环控制比较
    public int[] bubbleSort(int[] arr) {
        if (arr.length == 0)
            return arr;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;
    }


    static public int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            int minIndex = i;
            for (int j = i ; j < arr.length; j++) {
                if (arr[j]<arr[minIndex]) {
                    minIndex=j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
        return arr;

    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 6, 8,2};
        int[] ints = selectSort(arr);
        System.out.println(ints);


    }

}
