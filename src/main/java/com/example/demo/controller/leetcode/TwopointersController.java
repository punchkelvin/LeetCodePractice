package com.example.demo.controller.leetcode;

import com.example.demo.dto.TempDTO;
import com.example.demo.leetcodeSolutions.twoPointers.easy.IsPalindrome;
import com.example.demo.leetcodeSolutions.twoPointers.medium.ThreeIntegerSum;
import com.example.demo.leetcodeSolutions.twoPointers.medium.TwoSum2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TwopointersController {
    @Autowired IsPalindrome isPalindrome;
    @Autowired TwoSum2 twoSum2;
    @Autowired ThreeIntegerSum threeIntegerSum;

    @GetMapping("/isPalindrome")
    public boolean isPalindrome(@RequestBody TempDTO tempDTO) {
        return isPalindrome.isPalindrome(tempDTO.getString1());
    }

    @GetMapping("/twoSum2")
    public int[] twoSum2(@RequestBody TempDTO tempDTO) {
        return twoSum2.twoSum2(tempDTO.getIntArray1(), tempDTO.getInteger1());
    }

    @GetMapping("/threeIntegerSum")
    public List<List<Integer>> threeIntegerSum(@RequestBody TempDTO tempDTO) {
        return threeIntegerSum.threeSum2(tempDTO.getIntArray1());
    }
}
