package DP;

public class EditDistance72 {
    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }

    public static int minDistance(String word1, String word2) {
        if (word1.equals("")) {
            return word2.length();
        }
        if (word2.equals("")) {
            return word1.length();
        }
        int max = 0;
        int h = word1.length();
        int w = word2.length();
        int[][] matrix = new int[h][w];
        for (int j = 0; j < w; j++) {
            if (word2.charAt(j) == word1.charAt(0)) {
                matrix[0][j] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < h; i++) {
            if (word1.charAt(i) == word2.charAt(0)) {
                matrix[i][0] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                char first = word1.charAt(i);
                char second = word2.charAt(j);
                if (first == second) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        int sizeDiff = Math.abs(word1.length() - word2.length());
        return sizeDiff + word2.length() - max;
    }
}
