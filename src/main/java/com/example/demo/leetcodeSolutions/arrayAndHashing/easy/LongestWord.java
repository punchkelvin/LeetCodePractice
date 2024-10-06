package com.example.demo.leetcodeSolutions.arrayAndHashing.easy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LongestWord {
    // i!imma love doggss

    public String longestWord(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String finalResult = "";

        char[] charArray = str.toCharArray();

        log.info("length: " + charArray.length);
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetterOrDigit(charArray[i])) {
                stringBuilder.append(charArray[i]);
                log.info("Checkpoint: " + stringBuilder.toString());

            } else {
                log.info("Checkpoint2: " + stringBuilder.toString());
                if (stringBuilder.toString().length() > finalResult.length()) {
                    finalResult = stringBuilder.toString();
                }
                stringBuilder.delete(0, charArray.length - 1);
            }
        }

        if (stringBuilder.toString().length() > finalResult.length()) {
            finalResult = stringBuilder.toString();
        }

        return finalResult;
    }
}
