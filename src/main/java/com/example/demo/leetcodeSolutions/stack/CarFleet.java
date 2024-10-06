package com.example.demo.leetcodeSolutions.stack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Stack;

@Service
@Slf4j
public class CarFleet {
    // input = [10,8,0,5,3]
    // speed = [2,4,1,1,3]
    public int carFleet2(int target, int[] position, int[] speed) {

        if (position.length == 1) return 1;
        Stack<Double> stack = new Stack<>();
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, java.util.Comparator.comparingInt(o -> o[0]));
        // We check from the back
        for (int i = combine.length - 1; i >= 0; i--) {
            double currentTime = (double) (target - combine[i][0]) / combine[i][1];
            // If the time inside the stack has higher value than the current loop
            // means that the current time is going to overtake, but since its only 1 lane
            // it will become one fleet with the one slower infront
            if (!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            } else {
                stack.push(currentTime);
            }
        }
        return stack.size();
    }

    // This one has error
    public int carFleetOld(int target, int[] position, int[] speed) {
        int[][] combined = new int[position.length][2];
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            combined[i][0] = position[i];
            combined[i][1] = speed[i];
        }

        Arrays.sort(combined, java.util.Comparator.comparingInt(o -> o[0]));

        for (int i = 0; i < combined.length; i++) {
            double time = (double) (target - combined[i][0]) / combined[i][1];
            log.info("Time: " + time);

            if (!stack.isEmpty() && stack.peek() <= time) {
                //                stack.pop();
                log.info("stack peek is less and equal to time");
                continue;
            } else {
                log.info("stack peek is more and eqal to time");
                log.info("pushing to stack");
                stack.push(time);
            }
        }

        return stack.size();
    }
}
