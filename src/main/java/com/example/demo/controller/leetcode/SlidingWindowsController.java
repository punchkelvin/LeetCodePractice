package com.example.demo.controller.leetcode;

import com.example.demo.dto.TempDTO;
import com.example.demo.leetcodeSolutions.slidingWindows.BestTimeToBuyAndSellCrypto;
import com.example.demo.leetcodeSolutions.slidingWindows.LongestRepeatingSubstringWithReplacement;
import com.example.demo.leetcodeSolutions.slidingWindows.LongestSubstringWithoutDuplicates;
import com.example.demo.leetcodeSolutions.slidingWindows.PermutationInString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlidingWindowsController {
    @Autowired BestTimeToBuyAndSellCrypto bestTimeToBuyAndSellCrypto;
    @Autowired LongestSubstringWithoutDuplicates longestSubstringWithoutDuplicates;
    @Autowired LongestRepeatingSubstringWithReplacement longestRepeatingSubstringWithReplacement;
    @Autowired PermutationInString permutationInString;

    @GetMapping("/stringPermutation")
    public boolean stringPermutation(@RequestBody TempDTO tempDTO) {
        return permutationInString.checkInclusion(tempDTO.getString1(), tempDTO.getString2());
    }

    @GetMapping("/maxProfit")
    public int maxProfit(@RequestBody TempDTO tempDTO) {
        return bestTimeToBuyAndSellCrypto.maxProfit(tempDTO.getIntArray1());
    }

    @GetMapping("/lengthOfLongestSequence")
    public int lengthOfLongestSequence(@RequestBody TempDTO tempDTO) {
        return longestSubstringWithoutDuplicates.lengthOfLongestSubString(tempDTO.getString1());
    }

    @GetMapping("/longestRepeatingSubstringWithReplacement")
    public int longestRepeatingSubstringWithReplacement(@RequestBody TempDTO tempDTO) {
        return longestRepeatingSubstringWithReplacement.characterReplacement2(
                tempDTO.getString1(), tempDTO.getInteger1());
    }
}
