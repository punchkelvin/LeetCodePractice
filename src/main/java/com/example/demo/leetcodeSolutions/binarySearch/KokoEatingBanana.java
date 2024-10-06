package com.example.demo.leetcodeSolutions.binarySearch;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class KokoEatingBanana {
    // Input: piles = [1,4,3,2], h = 9
    // output = 2
    public int minEatingSpeed(int[] piles, int h) {
        int minEatingSpeed = 0;

        // Get the max
        for (int pile : piles) {
            minEatingSpeed = Math.max(minEatingSpeed, pile);
        }

        int left = 0;
        int right = minEatingSpeed;

        // Start the Binary
        while (left <= right) {
            int middle = (right - left) / 2 + left;

            int totalHour = 0;
            for (int pile : piles) {
                totalHour += Math.ceil((double) pile / middle);
            }

            if (totalHour > h) {
                left = middle + 1;
            } else {

                right = middle - 1;
                minEatingSpeed = Math.min(minEatingSpeed, middle);
            }
        }

        return minEatingSpeed;
    }
}
