package com.interview.experience.actual.algorithm;

import java.util.Arrays;

/**
 * 有序数组二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    }


    public static int binarySearch(int target, int[] arr){
        int key = 4;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
