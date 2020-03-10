package com.lzdd.adal.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @Author 1991tangfei@gmail.com
 * @Time 2020/3/9 8:50 下午
 **/
public class DuplicateData {
    /**
     * 题目：在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些
     * 数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数
     * 组中任意一个重复的数字。
     * 要求：时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不
     * 能使用额外的标记数组。
     */

    /**
     * 解题思路 https://cyc2018.github.io/CS-Notes/#/notes/3.%20%E6%95%B0%E7%BB%84%E4%B8%AD%E9%87%8D%E5%A4%8D%E7%9A%84%E6%95%B0%E5%AD%97
     *对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。本题要求
     * 找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
     */

    public static void duplicate(int[] nums,int length,int[] duplicate){
        if (nums == null || nums.length < 2 || length < 2){
            return;
        }

        for (int i = 0; i < length; i++){
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    duplicate[0] = nums[i];
                    return;
                }
                swap(nums,i,nums[i]);
            }
        }
    }

    public static void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,0, 3, 1, 6, 2, 6};
        int[] duplates = new int[1];
        DuplicateData.duplicate(nums,7,duplates);
        System.out.println(JSON.toJSONString(duplates));
    }

}
