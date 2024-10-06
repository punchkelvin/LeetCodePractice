package com.example.demo.leetcodeSolutions.arrayAndHashing.medium;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductOfArrayExceptSelf {
    //    Input: nums = [1,2,4,6]

    //    final       = [1,1,2,8]

    // right = 8
    //    final       = [1,1,2,8]

    // prefix = [1, 1, 2, 8]

    //    Output: [48,24,12,8]
    public int[] productExceptSelf2(int[] nums) {
        int[] finalArray = new int[nums.length];
        finalArray[1] = 1;

        // left scan
        for (int i = 1; i < nums.length; i++) {
            finalArray[i] = nums[i - 1] * finalArray[i - 1];
        }

        // right scan
        int rightValue = 1;
        for (int i = nums.length; i >= 0; i++) {
            finalArray[i] = finalArray[i] * rightValue;
            rightValue = rightValue * nums[i];
        }

        return finalArray;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] finalArray = new int[nums.length];

        finalArray[0] = 1;

        // prefix

        for (int i = 1; i < nums.length; i++) {
            finalArray[i] = finalArray[i - 1] * nums[i - 1];
        }

        int right = 1; // 6
        for (int i = nums.length - 1; i >= 0; i--) {
            finalArray[i] = finalArray[i] * right;
            right = right * nums[i];
        }

        return finalArray;
    }
}
