package com.example.demo.leetcodeSolutions.stack;

import org.springframework.stereotype.Service;
import java.util.Stack;

@Service
public class ScoreOfParanthesis {
    // input () -> score 1
    // input (()) -> score 22
    // input ()() -> score 2

    public int scoredOfParanthesis2(String s) {

        Stack<Integer> stack = new Stack<>();
        int score = 0;
        stack.push(score);

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int innerScore = stack.pop();
                int outerScore = stack.pop();

                stack.push(outerScore + Math.max(innerScore * 2, 1));
            }
        }
        return stack.pop();
    }

    public int scoreOfParanthesis(String s) {

        int score = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(score);

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(score);
            } else {
                int innerScore = stack.pop();
                int outerScore = stack.pop();

                stack.push(outerScore + Math.max(2 * innerScore, 1));
            }
        }

        return stack.pop();
    }
}
