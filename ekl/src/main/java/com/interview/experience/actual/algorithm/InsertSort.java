package com.interview.experience.actual.algorithm;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author Jiangkui
 * @since 2019/12/17 09:13
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 0, 2, 7, 9, 3, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int j;
                int temp = arr[i];
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }
}

