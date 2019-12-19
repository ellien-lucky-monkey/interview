package com.interview.experience.actual.algorithm;

import java.util.Arrays;

/**
 * 选择排序  每一轮选择一个最小的放在当前位置
 * @author Jiangkui
 * @since 2019/12/17 14:24
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 0, 2, 7, 9, 3, 1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }
}
