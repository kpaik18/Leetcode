package DP;

public class PredictTheWinner486 {
    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 2, 4, 6}));
    }

    static public boolean predictTheWinner(int[] nums) {
        Cell[][] dp = new Cell[nums.length][nums.length];
        createDp(dp);
        fillDp(dp, nums);
        printCellMatrix(dp);
        int s = nums.length - 1;
//        if (dp[0][s].score >= Math.max(dp[1][s].score, dp[0][s - 1].score)) {
//            return true;
//        }
        int myChoice = dp[0][s].score;
        int choice = dp[0][s].index;
        if (choice == 0) {
            return myChoice >= dp[1][s].score;
        }
        return myChoice >= dp[0][s - 1].score;
    }

    private static void printCellMatrix(Cell[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int index = dp[i][j].index;
                boolean left = true;
                if (index == j) {
                    left = false;
                }
                System.out.print(dp[i][j].score + (left ? "l" : "r") + " ");
            }
            System.out.println();
        }
    }

    private static void createDp(Cell[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = new Cell(0, 0);
            }
        }
    }

    static private void fillDp(Cell[][] dp, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            fillNlengthSubProblem(dp, nums, i);
        }
    }

    static private void fillNlengthSubProblem(Cell[][] dp, int[] nums, int len) {
        for (int i = 0; i < nums.length; i++) {
            int left = i;
            int right = i + len;
            if (right < nums.length)
                fillDpCell(dp, nums, left, right);
        }
    }

    private static void fillDpCell(Cell[][] dp, int[] nums, int left, int right) {
        if (left == right) {
            dp[left][right].score = nums[left];
            dp[left][right].index = left;
            return;
        }
        if (right - left == 1) {
            int max = Math.max(nums[left], nums[right]);
            dp[left][right].score = max;
            boolean isLeft = true;
            if (nums[right] > nums[left]) {
                isLeft = false;
            }
            if (isLeft) {
                dp[left][right].index = left;
            } else {
                dp[left][right].index = right;
            }
            return;
        }
        int leftChoice = nums[left];
        int rightChoice = nums[right];

        int enemyLeftIndex = dp[left + 1][right].index;
        int enemyRightIndex = dp[left][right - 1].index;

        int leftOptimalMax = 0;
        if (enemyLeftIndex == left + 1) {
            leftOptimalMax = dp[left + 2][right].score;
        } else {
            leftOptimalMax = dp[left + 1][right - 1].score;
        }
        int rightOptimalMax = 0;
        if (enemyRightIndex == left) {
            rightOptimalMax = dp[left + 1][right - 1].score;
        } else {
            rightOptimalMax = dp[left][right - 2].score;
        }
        int fullLeft = leftChoice + leftOptimalMax;
        int fullRight = rightChoice + rightOptimalMax;
        if (fullLeft > fullRight) {
            dp[left][right].score = fullLeft;
            dp[left][right].index = left;
        } else {
            dp[left][right].score = fullRight;
            dp[left][right].index = right;
        }

    }

    static class Cell {
        int index;
        int score;

        public Cell(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }
}
