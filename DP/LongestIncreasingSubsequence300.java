package DP;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        int fullMax = 1;
        int[] result = new int[nums.length];
        result[result.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int next = nums[i];
            boolean isLess = false;
            int max = 0;
            for (int j = i + 1; j < nums.length; j++) {
                int check = nums[j];
                if (next < check) {
                    isLess = true;
                    if (result[j] > max) {
                        max = result[j];
                    }
                }
            }
            if (isLess) {
                result[i] = 1 + max;
            } else {
                result[i] = 1;
            }
            if (result[i] > fullMax) {
                fullMax = result[i];
            }
        }
        return fullMax;
    }
}
