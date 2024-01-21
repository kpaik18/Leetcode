package DP.notDone;

import java.util.Arrays;
import java.util.List;

public class CoinChangeII518 {
    public static void main(String[] args) {
        System.out.println(change(500, new int[]{1, 2, 5}));
    }

    public static int change(int amount, int[] coins) {
        coins = Arrays.stream(coins).sorted().toArray();
        int result = helper(amount, coins, 0);
        return result;
    }

    private static int helper(int amount, int[] coins, int minIndex) {
        if (amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        int result = 0;
        for (int i = minIndex; i < coins.length; i++) {
            int next = coins[i];
            result += helper(amount - next, coins, i);
        }
        return result;

    }

    private static void printList(List<Integer> chosen) {
        for (var next : chosen) {
            System.out.print(next + " ");
        }
        System.out.println();
    }


}
