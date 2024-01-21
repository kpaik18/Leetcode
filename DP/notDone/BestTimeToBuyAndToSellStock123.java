package DP.notDone;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndToSellStock123 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{5, 4, 2, 5, 10, 3, 7, 6, 5, 4, 1, 10, 2}));
    }

    public static int maxProfit(int[] prices) {
        int startIndex = findFirstUphill(prices);
        if (startIndex == -1) {
            return 0;
        }
        List<List<Integer>> hills = new ArrayList<>();
        findHillsInArray(prices, startIndex, hills);
        return getMaxProfitInTwoTransactionsFromHills(hills);
    }

    private static int getMaxProfitInTwoTransactionsFromHills(List<List<Integer>> hills) {
        return 0;
    }

    private static void findHillsInArray(int[] prices, int startIndex, List<List<Integer>> hills) {
        int prev = prices[startIndex];
        int currentMin = prices[startIndex];
        int currentMax = prices[startIndex];
        for (int i = startIndex + 1; i < prices.length; i++) {
            int next = prices[i];
            if (next >= prev) {
                currentMax = next;
            }
            if (next < prev) {
                if (currentMin != currentMax) {
                    hills.add(List.of(currentMin, currentMax));
                }
                currentMax = next;
                currentMin = next;
            }
            prev = next;
        }
    }

    private static int findFirstUphill(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        if (prices[1] > prices[0]) {
            return 0;
        }
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int next = prices[i];
            if (next > prev) {
                return i - 1;
            }
            prev = next;
        }
        return -1;
    }

}
