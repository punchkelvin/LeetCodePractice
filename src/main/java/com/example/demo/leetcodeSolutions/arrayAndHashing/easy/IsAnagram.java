package com.example.demo.leetcodeSolutions.arrayAndHashing.easy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
@Slf4j
public class IsAnagram {
    String s = "racecar";
    String t = "carrace";

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabetCount = new int[26];

        for (char c : s.toLowerCase().toCharArray()) {
            alphabetCount[c - 'a']++;
        }

        for (char c : t.toLowerCase().toCharArray()) {
            alphabetCount[c - 'a']--;
        }

        for (int count : alphabetCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();

        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[52];

        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCounts[c - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramWithCharMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // int array for alphabet index
        int[] charCounts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // minus a to get the alphabet index
            // a is 97 in ascii, hence here it is the character index - 'a'(n - 97), hence 0 for
            // character a
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    // Uses More Memory
    public boolean isAnagramWithHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char x : s.toCharArray()) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }

        for (char x : t.toCharArray()) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) - 1);
        }

        for (Integer i : hashMap.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
