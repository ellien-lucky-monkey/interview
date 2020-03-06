package com.interview.experience.actual.algorithm;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * @author Jiangkui
 * @since 2019/12/19 17:12
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 3, 1, 9, 8, 7, 6, 5, 4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] arr) {

        int i = (arr.length - 1) / 2; //从最后一个非叶子节点建堆
        for (int j = i; j >= 0; j--) {
            heapify(arr, j, arr.length);
        }

        //先建堆一次

        for (int k = arr.length - 1; k > 0; k--) {
            int tmp = arr[0];
            arr[0] = arr[k];
            arr[k] = tmp;
            heapify(arr, 0, k);

        }
    }

    /**
     * 建堆
     *
     * @param arr
     * @param index
     * @param size
     */

    public static void heapify(int[] arr, int index, int size/*数组长度*/) {

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int maxIndex = index;

        if (left < size && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }
        if (right < size && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != index) {
            int tmp = arr[maxIndex];
            arr[maxIndex] = arr[index];
            arr[index] = tmp;
            heapify(arr, maxIndex, size);
        }

    }
}
