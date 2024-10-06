package com.example.demo.leetcodeSolutions.arrayAndHashing.easy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@Slf4j
@Service
public class TwoSum {
    int[] nums1 = {2, 7, 11, 15};
    int target = 9;

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (hashMap.containsKey(diff)) {
                return new int[] {hashMap.get(diff), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No Two Sum Found");
    }

    public int[] twoSumBruteForde(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No Two Sum Found");
    }

    public int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];

            if (hashMap.containsKey(number)) {
                return new int[] {hashMap.get(number), i};
            }

            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Two Sum Found");
    }
}
