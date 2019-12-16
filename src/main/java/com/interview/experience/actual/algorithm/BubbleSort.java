package com.interview.experience.actual.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 2, 9, 4, 5, 6, 7, 1, 3};
        bubbleSort(arr);
        bubbleSort1(arr);
        bubbleSort2(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }

    /**
     * 优化有序
     *
     * @param arr
     */
    public static void bubbleSort1(int[] arr) {
        int flag = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }


    /**
     * 优化部分排序
     *
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        int flag = 0;
        int pos = 0;
        int k = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            pos = 0;
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = 1;
                    pos = j;
                }
            }
            if (flag == 0) {
                break;
            }
            k = pos;
        }
        System.out.println("arr = " + Arrays.toString(arr));
    }
}
