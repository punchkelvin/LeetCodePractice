package com.example.demo.controller.leetcode;

import com.example.demo.dto.TempDTO;
import com.example.demo.leetcodeSolutions.stack.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Stack;

@RestController
public class StackController {
    Stack<Integer> stack = new Stack<>();
    @Autowired ValidateParantheses validateParantheses;
    @Autowired MinStack minStack;
    @Autowired EvaluateReversePolishNotation evaluateReversePolishNotation;
    @Autowired GenerateParanthesis generateParanthesis;
    @Autowired DailyTemperature dailyTemperatures;
    @Autowired CarFleet carFleet;
    @Autowired ScoreOfParanthesis scoreOfParanthesis;

    @GetMapping("/isValid")
    public boolean isValid(@RequestBody TempDTO tempDTO) {
        return validateParantheses.isValid(tempDTO.getString1());
    }

    @GetMapping("/minStack/push")
    public void minStackPush(@RequestBody TempDTO tempDTO) {
        minStack.push(tempDTO.getInteger1());
    }

    @GetMapping("/minStack/pop")
    public void minStackPop() {
        minStack.pop();
    }

    @GetMapping("/minStack/top")
    public void minStackTop() {
        minStack.top();
    }

    @GetMapping("/minStack/getMin")
    public int minStackGetMin() {
        return minStack.getMin();
    }

    @GetMapping("/minStack/getStack")
    public Stack<Integer> getStack() {
        return minStack.getStack();
    }

    @GetMapping("/evalRPN")
    public Integer evalRPN(@RequestBody TempDTO tempDTO) {
        return evaluateReversePolishNotation.evalRPN(tempDTO.getStringArray());
    }

    @GetMapping("/generateParanthesis")
    public List<String> generateParanthesis(@RequestBody TempDTO tempDTO) {
        return generateParanthesis.generateParanthesis(tempDTO.getInteger1());
    }

    @GetMapping("/dailyTemperatures")
    public int[] dailyTemperatures(@RequestBody TempDTO tempDTO) {
        return dailyTemperatures.dailyTemperatures(tempDTO.getIntArray1());
    }

    @GetMapping("/test/push")
    public Stack<Integer> stackPush(@RequestBody TempDTO tempDTO) {
        stack.push(tempDTO.getInteger1());
        return stack;
    }

    @GetMapping("/scoreOfParanthesis")
    public int scoreOfParanthesis(@RequestBody TempDTO tempDTO) {
        return scoreOfParanthesis.scoredOfParanthesis2(tempDTO.getString1());
    }

    @GetMapping("/test/pop")
    public int stackPop(@RequestBody TempDTO tempDTO) {
        return stack.pop();
    }

    @GetMapping("/carFleet")
    public int carFleet(@RequestBody TempDTO tempDTO) {
        return carFleet.carFleet2(
                tempDTO.getInteger1(), tempDTO.getIntArray1(), tempDTO.getIntArray2());
    }
}
