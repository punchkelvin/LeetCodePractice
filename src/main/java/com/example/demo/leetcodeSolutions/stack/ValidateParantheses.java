package com.example.demo.leetcodeSolutions.stack;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Stack;

@Service
public class ValidateParantheses {
    // input: "()"
    // input: "()[]{}"
    // input: "(]"
    // input: "([])"
    public boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!hashMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && hashMap.get(c) == stack.peek()) {
                    stack.pop();
                } else return false;
            }
        }

        return stack.isEmpty();
    }

    //    public boolean isValid(String s) {
    //        HashMap<Character, Character> paranthesisMap = new HashMap<>();
    //        paranthesisMap.put(')', '(');
    //        paranthesisMap.put('}', '{');
    //        paranthesisMap.put(']', '[');
    //
    //        Stack<Character> stack = new Stack<>();
    //        for (char c : s.toCharArray()) {
    //            if (paranthesisMap.containsKey(c)) {
    //                if (!stack.isEmpty() && stack.peek().equals(paranthesisMap.get(c))) {
    //                    stack.pop();
    //                } else return false;
    //            } else {
    //                stack.add(c);
    //            }
    //        }
    //        return stack.isEmpty();
    //    }
}
