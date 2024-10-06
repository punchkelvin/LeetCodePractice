package com.example.demo.leetcodeSolutions.twoPointers.hard;

import org.springframework.stereotype.Service;

@Service
public class TrappingRainWater {
    // [0,2,0,3,1,0,1,3,2,1]
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int totalWaterTrapped = 0;

        while (left < right) {
            int currentTrappedWater = 0;

            if (height[left] < height[right]) {
                left++;
                currentTrappedWater = leftMax - height[left];

                leftMax = Math.max(height[left], leftMax);

            } else {
                right--;
                currentTrappedWater = rightMax - height[right];

                rightMax = Math.max(height[right], rightMax);
            }
            if (currentTrappedWater < 0) currentTrappedWater = 0;
            totalWaterTrapped += currentTrappedWater;
        }
        return totalWaterTrapped;
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int totalTrappedWater = 0;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            if (height[left] < height[right]) {
                left++;

                int waterTrapped = leftMax - height[left];

                if (waterTrapped < 0) waterTrapped = 0;

                totalTrappedWater += waterTrapped;

                leftMax = Math.max(leftMax, height[left]);
            } else {
                right--;

                int trappedWater = rightMax - height[right];

                if (trappedWater < 0) trappedWater = 0;

                totalTrappedWater += trappedWater;

                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return totalTrappedWater;
    }
}
