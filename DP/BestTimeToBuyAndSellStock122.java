package DP;

public class BestTimeToBuyAndSellStock122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int result = 0;
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int next = prices[i];
            if (next >= prev) {
                max = next;
            }
            if (next < prev) {
                result += max - min;
                min = next;
                max = next;
            }
            prev = next;
        }
        return result + max - min;
    }
}
