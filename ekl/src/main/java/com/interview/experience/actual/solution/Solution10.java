package com.interview.experience.actual.solution;

import java.util.Arrays;

/**
 * @author Jiangkui
 * @since 2019/12/23 10:44
 */
public class Solution10 {


    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums1 = new int[]{3, 3, 6, 6, 6, 6, 6, 2};
//        System.out.println(removeElement(nums1, 3));
//        System.out.println(Arrays.toString(nums1));


//        String haystack = "hello", needle = "ll";
        String haystack = "abb", needle = "abaaa";
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "aaaaaabba", needle = "abba";
        System.out.println(strStr(haystack, needle));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                continue;
            }
            if (i != j) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    //实现indexOf 的功能
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int i = 0;
        int length = haystack.length() - needle.length();
        if (length < 0) {
            return -1;
        }
        for (; i <= length; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = 0;
                int j = 1;
                for (; j < needle.length(); j++) {
                    k = j + i;
                    if (haystack.charAt(k) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == needle.length()) {
                    return i;
                }
            }

        }
        return -1;
    }
}
