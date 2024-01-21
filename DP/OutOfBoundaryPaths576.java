package DP;

public class OutOfBoundaryPaths576 {

    public static void main(String[] args) {
        System.out.println(modulo);
        System.out.println(findPaths(8, 50, 23, 5, 26));
    }

    private static int modulo = 1_000_000_000 + 7;
    private static int result = 0;
    private static int x = 0;
    private static int y = 0;



    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove <= 0) {
            return 0;
        }
        result = 0;
        x = startRow;
        y = startColumn;
        int[][] counted = helper(m, n, maxMove);
        return result % modulo;
    }

    private static int[][] helper(int m, int n, int step) {
        if (step == 1) {
            int[][] base = new int[m][n];
            for (int i = 0; i < base.length; i++) {
                for (int j = 0; j < base[0].length; j++) {
                    int res = 0;
                    if (i == 0) {
                        res++;
                    }
                    if (i == base.length - 1) {
                        res++;
                    }
                    if (j == 0) {
                        res++;
                    }
                    if (j == base[0].length - 1) {
                        res++;
                    }
                    base[i][j] = res;
                }
            }
            result += base[x][y] % modulo;
            return base;
        }
        int[][] counted = helper(m, n, step - 1);
        int[][] current = new int[m][n];
        for (int i = 0; i < current.length; i++) {
            for (int j = 0; j < current[0].length; j++) {
                int res = 0;
                res += (((getOrDefault(counted, i + 1, j)
                        + getOrDefault(counted, i - 1, j)) % modulo
                        + getOrDefault(counted, i, j + 1)) % modulo
                        + getOrDefault(counted, i, j - 1)) % modulo;

                current[i][j] = res;
            }
        }
        result = (result % modulo + current[x][y] % modulo) % modulo;
        return current;
    }

    private static int getOrDefault(int[][] matrix, int i, int j) {
        if (i < 0 || i > matrix.length - 1) {
            return 0;
        }
        if (j < 0 || j > matrix[0].length - 1) {
            return 0;
        }
        return matrix[i][j] % modulo;
    }


}
