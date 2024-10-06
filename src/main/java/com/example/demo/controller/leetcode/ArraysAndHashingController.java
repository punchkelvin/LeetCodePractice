package com.example.demo.controller.leetcode;

import com.example.demo.dto.TempDTO;
import com.example.demo.hackerRank.IntegerToRoman;
import com.example.demo.leetcodeSolutions.arrayAndHashing.easy.ContainsDuplicate;
import com.example.demo.leetcodeSolutions.arrayAndHashing.easy.IsAnagram;
import com.example.demo.leetcodeSolutions.arrayAndHashing.easy.TwoSum;
import com.example.demo.leetcodeSolutions.arrayAndHashing.medium.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RestController
@Slf4j
public class ArraysAndHashingController {
    @Autowired ContainsDuplicate containsDuplicate;
    @Autowired IsAnagram isAnagram;
    @Autowired TwoSum twoSum;
    @Autowired GroupAnagram groupAnagram;
    @Autowired TopKFrequent topKFrequent;
    @Autowired StringEncodeDecode stringEncodeDecode;
    @Autowired ProductOfArrayExceptSelf productOfArrayExceptSelf;
    @Autowired ValidSudoku validSudoku;
    @Autowired LongestConsecutiveSequence longestConsecutiveSequence;
    @Autowired IntegerToRoman integerToRoman;

    @GetMapping("/containsDuplicate")
    public boolean containsDuplicateBruteForce(@RequestBody TempDTO tempDTO) {
        return containsDuplicate.containsDuplicateBruteForce(tempDTO.getIntArray1());
    }

    @GetMapping("/isAnagram")
    public boolean isAnagram(@RequestBody TempDTO tempDTO) {
        return isAnagram.isAnagram(tempDTO.getString1(), tempDTO.getString2());
    }

    @GetMapping("/twoSum")
    public int[] twoSum(@RequestBody TempDTO tempDTO) {
        return twoSum.twoSumHashMap(tempDTO.getIntArray1(), tempDTO.getInteger1());
    }

    @GetMapping("/groupAnagramSort")
    public List<List<String>> groupAnagram(@RequestBody TempDTO tempDTO) {
        return groupAnagram.groupAnagramWithSort(tempDTO.getStringArray());
    }

    @GetMapping("/groupAnagramCharCount")
    public List<List<String>> groupAnagramCharCount(@RequestBody TempDTO tempDTO) {
        return groupAnagram.groupAnagramWithCount(tempDTO.getStringArray());
    }

    @GetMapping("/topKFrequent")
    public int[] topKFrequent(@RequestBody TempDTO tempDTO) {
        return topKFrequent.topKFrequent(tempDTO.getIntArray1(), tempDTO.getInteger1());
    }

    @GetMapping("/encode")
    public String encode(@RequestBody TempDTO tempDTO) {
        return stringEncodeDecode.encode(tempDTO.getStringList());
    }

    @GetMapping("/decode")
    public List<String> decode(@RequestBody TempDTO tempDTO) {
        return stringEncodeDecode.decode2(tempDTO.getString1());
    }

    @GetMapping("/productOfArrays")
    public int[] productOfArrays(@RequestBody TempDTO tempDTO) {
        return productOfArrayExceptSelf.productExceptSelf(tempDTO.getIntArray1());
    }

    @GetMapping("/isValidSudoku")
    public boolean isValidSudoku(@RequestBody TempDTO tempDTO) {

        return validSudoku.isValidSudoku2(tempDTO.getBoard());
    }

    @GetMapping("/longestConsSequence")
    public int longestConsecutiveSequences(@RequestBody TempDTO tempDTO) {
        return longestConsecutiveSequence.longestConsSequence(tempDTO.getIntArray1());
    }

    @GetMapping("/intToRoman")
    public String intToRoman(@RequestBody TempDTO tempDTO) {
        return integerToRoman.intToRoman(tempDTO.getInteger1());
    }
}
