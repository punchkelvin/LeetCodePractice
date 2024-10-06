package com.example.demo.leetcodeSolutions.twoPointers.medium;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ThreeIntegerSum {
    // Input: nums = [-1,0,1,2,-1,-4]
    // Sorted = [-4, -1, -1, 0, 1, 2]
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalArray = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                log.info("checkpoint" + i, left, right);
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                }

                if (sum < 0) {
                    left++;
                }

                if (sum == 0) {
                    finalArray.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return finalArray;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> finalList = new ArrayList<>();

        //        int pointer1 = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int pointerLeft = i + 1;
            int pointerRight = nums.length - 1;

            while (pointerLeft < pointerRight) {

                int sum = nums[i] + nums[pointerLeft] + nums[pointerRight];

                if (sum == 0) {
                    finalList.add(
                            new ArrayList<>(
                                    Arrays.asList(nums[i], nums[pointerLeft], nums[pointerRight])));

                    while (pointerLeft < pointerRight
                            && nums[pointerLeft] == nums[pointerLeft + 1]) {
                        pointerLeft++;
                    }

                    while (pointerLeft < pointerRight
                            && nums[pointerRight] == nums[pointerRight - 1]) {
                        pointerRight--;
                    }

                    pointerLeft++;
                    pointerRight--;
                }

                if (sum > 0) {
                    pointerRight--;
                }

                if (sum < 0) {
                    pointerLeft++;
                }
            }
        }
        return finalList;
    }
}
