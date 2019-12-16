package com.interview.experience.actual.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 0, 2, 7, 9, 3, 1};
//        quickSort(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);
        System.out.println("args = " + Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int low = start;
        int high = end;

        int standard = arr[start];
        while (low < high) {
            //为什么还有一个low<high 因为 while循环中high的值一直在变化 不加这个判断的话会出现 [0,1,2,3,4] 右边的数都比0大 high会越界
            while (low < high && arr[high] >= standard) {
                high--;
            }
            arr[low] = arr[high];
            //为什么还有一个low<high 因为 while循环中high的值一直在变化
            while (low < high && arr[low] <= standard) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = standard;

        quickSort(arr, start, low);
        quickSort(arr, low + 1, end);

    }



    public static void quickSort2(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int low = start;
        int high = end;

        int standard = arr[start];
        while (low < high) {
            //为什么还有一个low<high 因为 while循环中high的值一直在变化 不加这个判断的话会出现 [0,1,2,3,4] 右边的数都比0大 high会越界
            while (low < high && arr[high] >= standard) {
                high--;
            }

            //为什么还有一个low<high 因为 while循环中high的值一直在变化
            while (low < high && arr[low] <= standard) {
                low++;
            }
            if (low < high) {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            }
        }

        //基准数处于第一位  换值到中间位置
        arr[start] = arr[low];
        arr[low] = standard;

        quickSort2(arr, start, low);
        quickSort2(arr, low + 1, end);

    }
}
