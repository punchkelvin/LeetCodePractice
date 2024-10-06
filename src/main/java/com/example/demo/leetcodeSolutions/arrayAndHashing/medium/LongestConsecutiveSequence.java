package com.example.demo.leetcodeSolutions.arrayAndHashing.medium;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.PriorityQueue;

@Service
public class LongestConsecutiveSequence {
    // nums = [2,20,4,10,3,4,5]
    // hashset = {2, 20, 4, 10, 3, 4, 5}

    public int longestConsecutiveSequence(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (Integer num : nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (Integer hashValue : hashSet) {
            int currentStreak = 1;

            if (!hashSet.contains(hashValue - 1)) {
                int currentNum = hashValue;

                while (hashSet.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            }
        }
        return longestStreak;
    }

    public int longestConsSequence(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (Integer num : nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;
        for (Integer num : hashSet) {

            int currentNum = num; // 2 -> 3 -> 4 -> 5

            // initial number
            if (!hashSet.contains(num - 1)) {
                int currentStreak = 1; // 2 -> 3 -> 4

                while (hashSet.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            }
        }
        return longestStreak;
    }
}
