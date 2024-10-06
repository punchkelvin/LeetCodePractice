package com.example.demo.leetcodeSolutions.arrayAndHashing.medium;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.*;

@Slf4j
@Service
public class GroupAnagram {
    String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

    public List<List<String>> groupAnagram(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String s : strs) {
            int[] alphabetCounts = new int[26];
            for (char c : s.toLowerCase().toCharArray()) {
                alphabetCounts[c - 'a']++;
            }

            StringBuilder hashed = new StringBuilder();
            for (int i : alphabetCounts) {
                hashed.append(i);
                hashed.append(",");
            }

            if (!hashMap.containsKey(hashed.toString())) {
                hashMap.put(hashed.toString(), new ArrayList<>());
            }
            hashMap.get(hashed.toString()).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }

    public List<List<String>> groupAnagramWithCount(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            int[] alphabetCharCount = new int[26];

            for (int i = 0; i < str.length(); i++) {
                alphabetCharCount[str.charAt(i) - 'a']++;
            }

            StringBuilder hashBuilder = new StringBuilder();
            for (int count : alphabetCharCount) {
                hashBuilder.append(count);
                // This is because the 0s and 1s might be the same for different string like
                // 'bdddddddddd' '010100000000000000000000000' and 'bbbbbbbbbbc'
                // '010100000000000000000000000'
                hashBuilder.append(",");
            }

            String hashedValue = hashBuilder.toString();

            log.info("Hahsed Value: " + "abcdefghijklmnopqrstuvwxyz");
            log.info("Hahsed Value: " + hashedValue);

            if (!hashMap.containsKey(hashedValue)) {
                hashMap.put(hashedValue, new ArrayList<>());
            }

            hashMap.get(hashedValue).add(str);
        }

        return new ArrayList<>(hashMap.values());
    }

    public List<List<String>> groupAnagramWithSort(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> hashMap = new HashMap<>(); // o(n)

        for (String str : strs) { // o(n)
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String sortedString = new String(charArray);

            if (!hashMap.containsKey(sortedString)) {
                hashMap.put(sortedString, new ArrayList<>());
            }

            hashMap.get(sortedString).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }

    public List<List<String>> groupAnagramsSort(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String sortedString = chars.toString();

            if (!anagramGroups.containsKey(sortedString)) {
                anagramGroups.put(sortedString, new ArrayList<>());
            }
            anagramGroups.get(sortedString).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    public List<List<String>> groupAnagramsHashed(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // Count the occurrence of each character
            int[] charCount = new int[26]; // Assuming input contains only lowercase English letters

            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }

            // Generate a hash using the character counts
            StringBuilder hashBuilder = new StringBuilder();
            for (int count : charCount) {
                hashBuilder.append(count);
            }
            String hash = hashBuilder.toString();

            // Group strings with the same hash
            if (!anagramGroups.containsKey(hash)) {
                anagramGroups.put(hash, new ArrayList<>());
            }
            anagramGroups.get(hash).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
