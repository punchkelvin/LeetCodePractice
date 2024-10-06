package com.example.demo.leetcodeSolutions.stack;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class GenerateParanthesis {
    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParanthesis2(int n) {
        backTrack(0, 0, n);
        return res;
    }

    public void backTrack2(int openParanthesis, int closedParanthesis, int n) {

        // If its a valid paranthesis
        if (openParanthesis == closedParanthesis && openParanthesis == n) {
            StringBuilder stringBuilder = new StringBuilder();

            for (Character c : stack) {
                stringBuilder.append(c);
            }

            res.add(stringBuilder.toString());
        }

        if (openParanthesis < n) {
            stack.push('(');
            backTrack2(openParanthesis + 1, closedParanthesis, n);
            stack.pop();
        }

        // Close Paranthesis
        if (closedParanthesis < openParanthesis) {
            stack.push(')');
            backTrack2(openParanthesis, closedParanthesis + 1, n);
            stack.pop();
        }
    }

    public List<String> generateParanthesis(int n) {
        backTrack(0, 0, n);
        return res;
    }

    public void backTrack(int openParanthesis, int closedParanthesis, int n) {
        // Valid Paranthesis
        if (openParanthesis == closedParanthesis && closedParanthesis == n) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c : stack) {
                stringBuilder.append(c);
            }

            res.add(stringBuilder.toString());
        }

        if (openParanthesis < n) {
            stack.push('(');
            backTrack(openParanthesis + 1, closedParanthesis, n);
            stack.pop();
        }

        if (closedParanthesis < openParanthesis) {
            stack.push(')');
            backTrack(openParanthesis, closedParanthesis + 1, n);
            stack.pop();
        }
    }
}
