package com.example.demo;

import com.example.demo.leetcodeSolutions.arrayAndHashing.medium.GroupAnagram;
import com.example.demo.leetcodeSolutions.arrayAndHashing.easy.IsAnagram;
import com.example.demo.leetcodeSolutions.arrayAndHashing.easy.ContainsDuplicate;
import com.example.demo.leetcodeSolutions.arrayAndHashing.easy.TwoSum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {
    private final ContainsDuplicate containsDuplicate;
    private final IsAnagram isAnagram;
    private final TwoSum twoSum;
    private final GroupAnagram groupAnagram;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Test Here
    }
}
