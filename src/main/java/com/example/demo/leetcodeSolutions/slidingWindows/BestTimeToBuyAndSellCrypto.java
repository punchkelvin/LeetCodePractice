package com.example.demo.leetcodeSolutions.slidingWindows;

import org.springframework.stereotype.Service;

@Service
public class BestTimeToBuyAndSellCrypto {
    // Input = [10,1,5,6,7,1]

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;
        int highestProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                highestProfit = Math.max(highestProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return highestProfit;
    }
}
