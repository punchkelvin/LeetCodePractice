package com.example.demo.leetcodeSolutions.twoPointers.medium;

import org.springframework.stereotype.Service;

@Service
public class TwoSum2 {
    //    Input: numbers = [1,3,4,5, 7, 10, 11], target = 9

    public int[] twoSumTraining(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
                continue;
            }
        }
        return new int[2];
    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            while (sum != target && sum > target) {
                right--;
                sum = numbers[left] + numbers[right];
            }
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }
            left++;
        }

        return new int[2];
    }
}
