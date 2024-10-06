package com.example.demo.leetcodeSolutions.slidingWindows;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class LongestRepeatingSubstringWithReplacement {

    // Input: s = "XYYX", k = 2
    // Output: 4

    // Input: s = "AAABABB", k = 1
    // output 5
    public int characterReplacement2(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int highestCount = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            hashMap.put(s.charAt(right), hashMap.getOrDefault(s.charAt(right), 0) + 1);

            highestCount = Math.max(highestCount, hashMap.get(s.charAt(right)));

            int windowsSize = right - left + 1;

            // window invalid (the amount of character in the window that is not the one
            // that has highest count )
            if (windowsSize - highestCount > k) {
                hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) - 1);
                left++;
                windowsSize = right - left + 1;
            }

            maxLength = Math.max(maxLength, windowsSize);
        }

        return maxLength;
    }
}
