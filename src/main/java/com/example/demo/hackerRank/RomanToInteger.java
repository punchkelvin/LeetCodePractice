package com.example.demo.hackerRank;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class RomanToInteger {

    public int romanToInteger(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int totalSum = 0;

        char[] charArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && hashMap.get(charArray[i]) < hashMap.get(charArray[i + 1])) {
                int currentAmount = hashMap.get(charArray[i + 1]) - hashMap.get(charArray[i]);
                totalSum += currentAmount;
                i++;
            } else {
                totalSum += hashMap.get(charArray[i]);
            }
        }

        return totalSum;
    }
}
