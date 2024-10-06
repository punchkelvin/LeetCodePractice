package com.example.demo.leetcodeSolutions.string;

import org.springframework.stereotype.Service;

@Service
public class RemoveOutermostParanthesis {
    public String removeOuterParanthesis2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int openParanthesisCount = 0;

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                if (openParanthesisCount > 0) {
                    stringBuilder.append(c);
                }
                openParanthesisCount++;
            } else {
                openParanthesisCount--;
                if (openParanthesisCount > 0) {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }

    public String removeOuterParanthesis(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int openParanthesisCount = 0;

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                if (openParanthesisCount > 0) {
                    stringBuilder.append(c);
                }
                openParanthesisCount++;
            } else {
                openParanthesisCount--;
                if (openParanthesisCount > 0) {
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }
}
