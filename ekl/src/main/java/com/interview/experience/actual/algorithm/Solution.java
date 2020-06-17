package com.interview.experience.actual.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
        System.out.println(123/10);
        System.out.println(123%10);



    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    //空间换时间
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (!map.containsKey(value)) {
                map.put(nums[i], i);
            } else {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }


    /**
     * 回文数  121  1221
     * @param x
     * @return
     */


    public boolean isPalindrome(int x) {

        int tmp = 0;

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        if (x < 10) return true;
        while (x > tmp) {
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }

        if (tmp == x || tmp / 10 == x) {
            return true;
        } else {
            return false;
        }
    }
}
