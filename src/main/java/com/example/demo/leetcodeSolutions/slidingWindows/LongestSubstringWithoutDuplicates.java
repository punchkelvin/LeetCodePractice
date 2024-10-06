package com.example.demo.leetcodeSolutions.slidingWindows;

import org.springframework.stereotype.Service;
import java.util.HashSet;

@Service
public class LongestSubstringWithoutDuplicates {
    public int lengthOfLongestSubString2(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (hashSet.contains(s.charAt(right))) {
                hashSet.remove(s.charAt(left));
                left++;
            }

            hashSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public int lengthOfLongestSubString(String s) {
        // a
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Character> hashSet = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            if (!hashSet.contains(s.charAt(right))) {
                hashSet.add(s.charAt(right));

            } else {
                //                maxLength = right - left;
                while (hashSet.contains(s.charAt(right))) {
                    hashSet.remove(s.charAt(left));
                    left++;
                }
                hashSet.add(s.charAt(right));
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
