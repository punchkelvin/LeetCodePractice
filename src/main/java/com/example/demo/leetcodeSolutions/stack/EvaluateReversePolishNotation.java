package com.example.demo.leetcodeSolutions.stack;

import org.springframework.stereotype.Service;
import java.util.Stack;

@Service
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer currentValue = 0;

        // Deconstruct the token
        for (String str : tokens) {
            if (str.equalsIgnoreCase("+")) {
                currentValue = stack.peek();
                stack.pop();
                currentValue += stack.peek();
                stack.pop();
                stack.push(currentValue);

            } else if (str.equalsIgnoreCase("-")) {
                currentValue = stack.peek();
                stack.pop();
                currentValue = stack.peek() - currentValue;
                stack.pop();
                stack.push(currentValue);

            } else if (str.equalsIgnoreCase("*")) {
                currentValue = stack.peek();
                stack.pop();
                currentValue *= stack.peek();
                stack.pop();
                stack.push(currentValue);

            } else if (str.equalsIgnoreCase("/")) {
                currentValue = stack.peek();
                stack.pop();
                currentValue = stack.peek() / currentValue;
                stack.pop();
                stack.push(currentValue);

            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.peek();
    }
}
