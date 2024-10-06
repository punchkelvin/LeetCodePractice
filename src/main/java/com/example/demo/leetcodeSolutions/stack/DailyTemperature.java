package com.example.demo.leetcodeSolutions.stack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
@Slf4j
public class DailyTemperature {
    // Input: temperatures = [30,38,30,36,35,40,28]

    // Output: [1,4,1,2,1,0,0]
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
                log.info("Stack: " + stack.toString());
                int prevDay = stack.pop();
                log.info("Prev Day: " + prevDay);
                ans[prevDay] = currDay - prevDay;
                log.info("Ans: " + ans);
            }
            stack.add(currDay);
        }
        return ans;
    }
}
