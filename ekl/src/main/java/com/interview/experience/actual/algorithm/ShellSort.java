package com.interview.experience.actual.algorithm;

import java.util.Arrays;

/**
 * 希尔排序
 * @author Jiangkui
 * @since 2019/12/17 09:56
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 7, 6, 4, 9, 0, 3};
        shellSort(arr);
        System.out.println("args = [" + Arrays.toString(arr) + "]");
    }

    public static void shellSort(int[] arr) {
        int step = 1;
        while (step < arr.length) {
            step = step * 3 + 1;
        }

        while (step > 0) {
            for (int i = step; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = tmp;
            }
            step = (int) Math.floor(step / 3);
        }
    }
}
