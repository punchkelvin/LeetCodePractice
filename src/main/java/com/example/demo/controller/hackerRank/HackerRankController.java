package com.example.demo.controller.hackerRank;

import com.example.demo.dto.TempDTO;
import com.example.demo.hackerRank.RomanToInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HackerRankController {

    @Autowired RomanToInteger romanToInteger;

    @GetMapping("/romanToInteger")
    public int romanToInteger(@RequestBody TempDTO tempDTO) {
        return romanToInteger.romanToInteger(tempDTO.getString1());
    }
}
