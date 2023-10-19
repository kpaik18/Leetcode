package DP;

public class DungeonGame174 {
    public static void main(String[] args) {
        int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        printMatrix(dungeon);
        System.out.println(calculateMinimumHP(dungeon));
    }

    private static void printMatrix(int[][] m) {
        System.out.println();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] minHealth = new int[dungeon.length][dungeon[0].length];
        int lastRow = dungeon.length - 1;
        int lastColumn = dungeon[0].length - 1;
        minHealth[lastRow][lastColumn] = 1;
        if (dungeon[lastRow][lastColumn] <= 0) {
            minHealth[lastRow][lastColumn] = -dungeon[lastRow][lastColumn] + 1;
        }
        calculateLastRow(dungeon, minHealth);
        calculateLastColumn(dungeon, minHealth);
        calculateMatrix(dungeon, minHealth);
        return dungeon[0][0] + 1;
    }

    private static void calculateMatrix(int[][] dungeon, int[][] minHealth) {
        for (int i = dungeon.length - 2; i >= 0; i--) {
            for (int j = dungeon[0].length - 2; j >= 0; j--) {
                int a = minHealth[i + 1][j];
                int b = minHealth[i][j + 1];
                int c = Math.min(a, b);
                minHealth[i][j] = Math.max(1, c - dungeon[i][j]);
            }
        }
    }

    private static void calculateLastColumn(int[][] dungeon, int[][] minHealth) {
        int lastColumnIndex = dungeon[0].length - 1;
        for (int i = dungeon.length - 2; i >= 0; i--) {
            int nextMinHealth = minHealth[i + 1][lastColumnIndex];
            minHealth[i][lastColumnIndex] = Math.max(1, nextMinHealth - dungeon[i][lastColumnIndex]);
        }
    }

    private static void calculateLastRow(int[][] dungeon, int[][] minHealth) {
        int lastRowIndex = dungeon.length - 1;
        for (int j = dungeon[0].length - 2; j >= 0; j--) {
            int nextMinHealth = minHealth[lastRowIndex][j + 1];
            minHealth[lastRowIndex][j] = Math.max(1, nextMinHealth - dungeon[lastRowIndex][j]);
        }
    }
}
