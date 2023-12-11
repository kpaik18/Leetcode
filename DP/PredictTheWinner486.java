package DP;

public class PredictTheWinner486 {
    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 2}));
    }

    static public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        fillDp(dp, nums);
        int size = nums.length - 1;
        if (dp[0][size] >= Math.max(dp[1][size], dp[0][size - 1])) {
            return true;
        }
        return false;
    }

    static private void fillDp(int[][] dp, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            fillNlengthSubProblem(dp, nums, i);
        }
    }

    static private void fillNlengthSubProblem(int[][] dp, int[] nums, int len) {
        for (int i = 0; i < nums.length; i++) {
            int left = i;
            int right = i + len;
            if (right < nums.length)
                fillDpCell(dp, nums, left, right);
        }
    }

    private static void fillDpCell(int[][] dp, int[] nums, int left, int right) {
        if (left == right) {
            dp[left][right] = nums[left];
            return;
        }
        if (right - left == 1) {
            dp[left][right] = Math.max(nums[left], nums[right]);
            return;
        }
        int leftChoiceEnemyWin = dp[left + 1][right];
        int rightChoiceEnemyWin = dp[left][right - 1];

    }
}
