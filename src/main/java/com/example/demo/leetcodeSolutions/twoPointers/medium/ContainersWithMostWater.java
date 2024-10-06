package com.example.demo.leetcodeSolutions.twoPointers.medium;

import org.springframework.stereotype.Service;

@Service
public class ContainersWithMostWater {
    //    height = [1,7,2,5,4,7,3,6]

    public int maxArea2(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int highestArea = 0;

        while (left < right) {
            int lowerHeight = Math.min(heights[left], heights[right]);
            int width = right - left;
            int currentArea = lowerHeight * width;
            highestArea = Math.max(currentArea, highestArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return highestArea;
    }

    public int maxArea(int[] heights) {
        int highestArea = 0;

        int pointerLeft = 0;
        int pointerRight = heights.length - 1;

        while (pointerLeft < pointerRight) {
            int lowerHeight = Math.min(heights[pointerLeft], heights[pointerRight]);
            int distance = pointerRight - pointerLeft;
            int currentArea = lowerHeight * distance;

            if (highestArea < currentArea) {
                highestArea = currentArea;
            }

            if (heights[pointerLeft] < heights[pointerRight]) {
                pointerLeft++;
            } else if (heights[pointerRight] < heights[pointerLeft]) {
                pointerRight--;
            } else {
                pointerLeft++;
            }
        }

        return highestArea;
    }
}
