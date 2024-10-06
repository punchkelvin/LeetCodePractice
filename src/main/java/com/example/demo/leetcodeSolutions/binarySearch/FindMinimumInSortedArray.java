package com.example.demo.leetcodeSolutions.binarySearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Stack;

@Service
@Slf4j
public class FindMinimumInSortedArray {
    // Input: nums = [4,5,6,7,0,1,2]
    // output: 0

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // if the array is not sorted, direct return from index 0
        if (nums[right] > nums[left]) {
            return nums[left];
        }

        while (left < right) {
            int middle = (right - left) / 2 + left;

            // check if the target is in left or right sorted array
            if (nums[middle] > nums[right]) {
                // middle is in left sorted array
                // this means that the minimum value is at right sorted array
                // because that the array has already been rotated, nums[left] will never the
                // smallest
                // and nums[left] up to mid won't be the smallest either as it is in increasing
                // order
                // hence we need to search the right side by moving the pointers of left to mid + 1

                // left = mid + 1 because, the value of mid is not the smallest
                // the only time where mid is the smallest is when the mid is at the right sorted
                // array
                left = middle + 1;

            } else {
                // middle is in right sorted array
                // anything from the middle to the right will be in increasing order, so its
                // impossible
                // for the minimum to be on the right array, so we check the left side
                // the smallest value might be in the middle
                // hence we move the right ot mid instead of mid - 1
                right = middle;
            }
        }

        return nums[left];
    }

    public int findMinOk(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input Array Invalid");
        }

        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int middle = (right - left) / 2 + left;

            // check if mid elementis greater than right, we know the minimum is in the right
            // and its not possible for it to be in the middle as the middle is already more than
            // the
            if (nums[middle] > nums[right]) {
                left = middle;
            } else {
                // the minimum could be in the mid or the left half
                right = middle;
            }
        }

        return nums[left];
    }
}
