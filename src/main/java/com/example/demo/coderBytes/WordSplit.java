package com.example.demo.coderBytes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Slf4j
@Service
public class WordSplit {

    //    String[] arr = {"hellocat", "apple,bat,cat,goodbye,hello,yellow,why"};
    public List<String> wordSplit(String[] arr) {
        String stringToBeSplit = arr[0];
        List<String> stringList = Arrays.asList(arr[1].split(","));

        HashSet<String> hashSet = new HashSet<>();
        for (String str : stringList) {
            hashSet.add(str);
        }

        for (int secondIndex = 1; secondIndex < stringToBeSplit.length(); secondIndex++) {
            String str = stringToBeSplit.substring(0, secondIndex);
            String str2 = stringToBeSplit.substring(secondIndex, stringToBeSplit.length());

            if (hashSet.contains(str) && hashSet.contains(str2)) {
                return Arrays.asList(str, str2);
            }
        }

        return new ArrayList<>();
    }
}
