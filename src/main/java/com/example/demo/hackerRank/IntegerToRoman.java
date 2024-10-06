package com.example.demo.hackerRank;

import org.springframework.stereotype.Service;

@Service
public class IntegerToRoman {
    // input 3749
    // output MMMDCCXLIX

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] intArray = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] stringArray =
                new String[] {
                    "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
                };

        int leftNum = num;
        int index = 0;

        while (leftNum > 0) {

            while (intArray[index] > leftNum) {
                index++;
            }

            int numSubtracted = leftNum - (leftNum % intArray[index]); // 3000
            leftNum = leftNum % intArray[index]; // 749

            // Building the roman
            while (numSubtracted > 0) {
                while (numSubtracted < intArray[index]) {
                    index++;
                }
                numSubtracted = numSubtracted - intArray[index];
                stringBuilder.append(stringArray[index]);
            }
        }

        return stringBuilder.toString();
    }
}
