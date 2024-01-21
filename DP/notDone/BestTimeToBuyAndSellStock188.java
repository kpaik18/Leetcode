package DP.notDone;

public class BestTimeToBuyAndSellStock188 {
    public static void main(String[] args) {
//        System.out.println(maxProfit());
    }

    public static int maxProfit(int k, int[] prices) {
        int profit = 0;
        int currentMin = prices[0];
        int currentMax = prices[1];
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int next = prices[i];
            if (next >= prev) {
                currentMax = next;
            } else {
                profit += currentMax - currentMin;
                currentMax = next;
                currentMin = next;
            }
        }
        profit += currentMax - currentMin;
        return profit;
    }
}
