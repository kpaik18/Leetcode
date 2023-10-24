package DP;

import static DP.utils.MatrixUtils.printMatrix;

public class DistinctSubsequences115 {
    public static void main(String[] args) {
        System.out.println(numDistinct("ddd", "dd"));
    }

    public static int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        int h = s.length();
        int w = t.length() + 1;
        int[][] matrix = new int[h][w];
        for (int i = 0; i < h; i++) {
            matrix[i][w - 1] = 1;
        }
        if (s.charAt(h - 1) == t.charAt(w - 2)) {
            matrix[h - 1][w - 2] = 1;
        }
//        printMatrix(matrix);
        System.out.println();
        for (int i = h - 2; i >= 0; i--) {
            for (int j = w - 2; j >= 0; j--) {
                if (h - i < w - 1 - j) {
                    continue;
                }
                char sChar = s.charAt(i);
                int tChar = t.charAt(j);
                matrix[i][j] = matrix[i + 1][j];
                if (sChar == tChar) {
                    matrix[i][j] += matrix[i + 1][j + 1];
                }
            }
        }
//        printMatrix(matrix);
        return matrix[0][0];
    }


}
