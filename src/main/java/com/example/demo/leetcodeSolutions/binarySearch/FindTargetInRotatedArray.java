package com.example.demo.leetcodeSolutions.binarySearch;

import org.springframework.stereotype.Service;

@Service
public class FindTargetInRotatedArray {
    //    Input: nums = [3,4,5,6,1,2], target = 1

    //    Output: 4
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int middle = (right - left) / 2 + left;

            if()
        }

        return -1;
    }

    public int searchOk(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If the target is found
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[mid] >= nums[left]) {
                // If target lies within the sorted left half
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // If the right half is sorted
            else {
                // If target lies within the sorted right half
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid~ + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // If the target is not found
        return -1;
    }
}
