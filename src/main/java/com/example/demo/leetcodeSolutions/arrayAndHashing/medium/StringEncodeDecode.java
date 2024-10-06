package com.example.demo.leetcodeSolutions.arrayAndHashing.medium;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StringEncodeDecode {

    // ["neet","code","love","you"]
    public String encode2(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str);
            encodedString.append("#");
        }

        return encodedString.toString();
    }

    // 4#neet4#code14#testingtesting4#here
    public List<String> decode2(String str) {
        int index1 = 0;
        List<String> arrayList = new ArrayList<>();

        while (index1 < str.length()) {
            int index2 = index1;

            while (str.charAt(index2) != '#') {
                index2++;
            }

            int size = Integer.parseInt(str.substring(index1, index2));

            index1 = index2 + 1 + size;

            arrayList.add(str.substring(index2 + 1, index1));
        }

        return arrayList;
    }

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();

        for (String str : strs) {
            encodedString.append(str.length() + "#" + str);
        }
        return encodedString.toString();
    }

    // 5#n2eet 5#co2de5#lo1ve3#you
    // index = n
    // index2 = 5
    // 5#n2eet 5#co2de 5#lo1ve 3#you

    // 4#neet4#code14#testingtesting#4here
    public List<String> decode(String str) {
        List<String> resultString = new ArrayList<>();

        int index2 = 0;
        while (index2 < str.length()) {
            int index = index2;

            while (str.charAt(index) != '#') {
                index++;
            }
            log.info("Index 2: " + index2);
            log.info("Index: " + index);
            int stringSize = Integer.parseInt(str.substring(index2, index));

            index2 = stringSize + index + 1;

            resultString.add(str.substring(index + 1, index2));
            log.info("Result: " + resultString);
        }
        return resultString;
    }
}
