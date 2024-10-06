package com.example.demo.leetcodeSolutions.arrayAndHashing.easy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@Slf4j
public class ContainsDuplicate {
    int[] testData1 = {1, 2, 3, 1};

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return true;
            } else {
                hashSet.add(num);
            }
        }
        return false;
    }

    // Brute Force
    public boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // Memory Usage was 61.24 mb, one of the lowest
    public boolean containsDuplicatesHashSet(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int num : nums) {
            // If hashset didn't add anything, means there a duplicate
            if (!hashSet.add(num)) {
                return true;
            }
        }
        return false;
    }

    // Memory Usage was about 58ish
    public boolean containsDuplicates2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (hashSet.contains(i)) {
                return true;
            }
            hashSet.add(i);
        }
        return false;
    }
}
