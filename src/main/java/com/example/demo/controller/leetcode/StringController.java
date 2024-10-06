package com.example.demo.controller.leetcode;

import com.example.demo.dto.TempDTO;
import com.example.demo.leetcodeSolutions.arrayAndHashing.easy.LongestWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {
    @Autowired LongestWord longestWord;

    @GetMapping("/longestWord")
    public String longestWord(@RequestBody TempDTO tempDTO) {
        return longestWord.longestWord(tempDTO.getString1());
    }
}
