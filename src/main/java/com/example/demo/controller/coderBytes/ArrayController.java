package com.example.demo.controller.coderBytes;

import com.example.demo.coderBytes.WordSplit;
import com.example.demo.dto.TempDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ArrayController {
    @Autowired WordSplit wordSplit;

    @GetMapping("/wordSplit")
    public List<String> wordSplit(@RequestBody TempDTO tempDTO) {
        return wordSplit.wordSplit(tempDTO.getStringArray());
    }
}
