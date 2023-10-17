package DP;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int currentMin = prices[0];
        int currentMax = prices[0];
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            int next = prices[i];
            if (next <= currentMin) {
                currentMin = next;
                currentMax = next;
            }
            if (next >= currentMax) {
                currentMax = next;
            }
            if (currentMax - currentMin > result) {
                result = currentMax - currentMin;
            }
        }
        return result;
    }

}
