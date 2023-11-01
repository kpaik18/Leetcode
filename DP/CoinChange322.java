package DP;

import java.util.HashSet;
import java.util.Set;

public class CoinChange322 {
    public static void main(String[] args) {
        int[] coins = new int[]{1016141230,
                1721235202, 1418258945, 143423694, 1297455580, 422874992, 1068724689, 276540907, 1879755362, 1631617596};
        System.out.println(coinChange(coins, 9999));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount % 2 == 1 && noEvenFound(coins)) {
            return -1;
        }
        Set<Integer> nodes = new HashSet<>();
        for (var coin : coins) {
            nodes.add(coin);
        }
        int iter = 1;
        while (true) {
            if (nodes.contains(amount)) {
                return iter;
            }
            iter++;
            Set<Integer> newNodes = new HashSet<>();
            boolean allIsMore = true;
            for (var coin : coins) {
                for (var next : nodes) {
                    newNodes.add(coin + next);
                    if (coin >= amount) {
                        continue;
                    }
                    if (next >= amount) {
                        continue;
                    }
                    if (coin + next <= amount) {
                        allIsMore = false;
                    }
                }
            }
            nodes.clear();
            nodes.addAll(newNodes);
            if (allIsMore) {
                return -1;
            }
        }

    }

    private static boolean noEvenFound(int[] coins) {
        for (var coin : coins) {
            if (coin % 2 == 1) {
                return false;
            }
        }
        return true;
    }


}
