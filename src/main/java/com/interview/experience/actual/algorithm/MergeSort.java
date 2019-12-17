package com.interview.experience.actual.algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 2, 4, 6, 8, 10};
        int[] arr2 = new int[]{1, 3, 5, 2, 4, 9, 8, 10};

        mergeSort(arr2, 0, arr2.length - 1);
        merge(arr, 0, 2, arr.length - 1);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arr2 = " + Arrays.toString(arr2));
    }

    public static void mergeSort(int[] arr, int left, int right) {

        if (left >= right) return;
        int mid = (right + left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }


    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (j <= right && i <= mid) {
            if (arr[i] < arr[j]) {
                tmp[index++] = arr[i];
                i++;
            } else {
                tmp[index++] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            tmp[index++] = arr[i];
            i++;
        }
        while (j <= right) {
            tmp[index++] = arr[j];
            j++;
        }

        for (int k = 0; k < tmp.length; k++) {
            arr[k + left] = tmp[k];
        }

    }
}
