package org.example.p_dynamicProgramming;

import java.util.Arrays;

/*
    Coin Change
    https://leetcode.com/problems/coin-change/
 */
public class P17_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        if (coins.length == 0)
            return -1;

        var combination = new int[amount + 1];
        Arrays.fill(combination, amount + 1);
        combination[0] = 0;

        for (var coin : coins) {
            for (var i = coin; i <= amount; ++i) {
                combination[i] = Math.min(combination[i], combination[i - coin] + 1);
            }
        }

        return combination[amount] > amount ? -1 : combination[amount];
    }
}
