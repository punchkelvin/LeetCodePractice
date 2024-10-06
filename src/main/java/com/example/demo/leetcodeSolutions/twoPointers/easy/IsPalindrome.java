package com.example.demo.leetcodeSolutions.twoPointers.easy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Slf4j
public class IsPalindrome {
    //    Input: s = "Was it a car or a cat I saw?"
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (s.toLowerCase().charAt(left) == s.toLowerCase().charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeHashSet(String s) {

        char[] charArray = s.toCharArray();
        StringBuilder firstOrder = new StringBuilder();
        StringBuilder flippedOrder = new StringBuilder();

        for (char c : charArray) {
            log.info("Char: " + c);
            if (c != ' ' && Character.isLetterOrDigit(c)) {
                firstOrder.append(c);
            }
        }

        for (int i = charArray.length - 1; i >= 0; i--) {
            log.info("Char: " + charArray[i]);
            if (charArray[i] != ' ' && Character.isLetterOrDigit(charArray[i])) {
                flippedOrder.append(charArray[i]);
            }
        }

        log.info("String1: " + firstOrder.toString());
        log.info("String2: " + flippedOrder.toString());

        if (!firstOrder.toString().equalsIgnoreCase(flippedOrder.toString())) {
            return false;
        }

        return true;
    }
}
