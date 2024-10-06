package com.example.demo.leetcodeSolutions.binarySearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BinarySearch {
    // Input: nums = [-1,0,2,4,6,8], target = 4
    // output: 3

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (right - left) / 2 + left;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public int searchOK(int[] nums, int target) {
        int middle = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            middle = ((right - left) / 2) + left;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
