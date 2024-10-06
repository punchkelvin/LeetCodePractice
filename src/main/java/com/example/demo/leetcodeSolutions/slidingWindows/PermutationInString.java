package com.example.demo.leetcodeSolutions.slidingWindows;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
@Slf4j
public class PermutationInString {
    // Input: s1 = "abc", s2 = "lecabee"
    // Output: true
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // s1 char count
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            // frequency for s1
            s1Freq[s1.charAt(i) - 'a']++;
            // frequency for window slider
            windowFreq[s2.charAt(i) - 'a']++;
        }

        log.info("s1 freq: " + s1Freq);
        log.info("window freq: " + windowFreq);

        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }
}
