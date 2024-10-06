package com.example.demo.controller.leetcode;

import com.example.demo.dto.TempDTO;
import com.example.demo.leetcodeSolutions.binarySearch.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BinarySearchController {
    @Autowired BinarySearch binarySearch;
    @Autowired Search2DMatrix search2DMatrix;
    @Autowired KokoEatingBanana kokoEatingBanana;
    @Autowired FindMinimumInSortedArray findMinimumInSortedArray;
    @Autowired FindTargetInRotatedArray findTargetInRotatedArray;

    @GetMapping("/binarySearch")
    public int search(@RequestBody TempDTO tempDTO) {
        return binarySearch.search(tempDTO.getIntArray1(), tempDTO.getInteger1());
    }

    @GetMapping("/searchMatrix")
    public boolean searchMatrix(@RequestBody TempDTO tempDTO) {
        return search2DMatrix.searchMatrix(tempDTO.getIntArray2d1(), tempDTO.getInteger1());
    }

    @GetMapping("/kokoEatingBanana")
    public int kokoEatingBanana(@RequestBody TempDTO tempDTO) {
        return kokoEatingBanana.minEatingSpeed(tempDTO.getIntArray1(), tempDTO.getInteger1());
    }

    @GetMapping("/doublediv")
    public int doublediv(@RequestBody TempDTO tempDTO) {
        int totalHour = 0;
        totalHour += Math.ceil(tempDTO.getInteger1() / tempDTO.getInteger2());
        return totalHour;
    }

    @GetMapping("/findMinimumInSortedArray")
    public int FindMinimumInSortedArray(@RequestBody TempDTO tempDTO) {
        return findMinimumInSortedArray.findMin(tempDTO.getIntArray1());
    }

    @GetMapping("/findTargetInSortedArray")
    public int findTargetInSortedArray(@RequestBody TempDTO tempDTO) {
        return findTargetInRotatedArray.search(tempDTO.getIntArray1(), tempDTO.getInteger1());
    }
}
