package DP;

import DP.utils.MatrixUtils;

public class RangeSumQuery304 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
//        ,[2,1,4,3],[1,1,2,2],[1,2,2,4]]
        NumMatrix m = new NumMatrix(matrix);
        System.out.println(m.sumRegion(1, 1, 2, 2));
    }

    static class NumMatrix {
        private int[][] sums;

        public NumMatrix(int[][] matrix) {
            sums = new int[matrix.length][matrix[0].length];
            fillSumsMatrix(matrix);
            MatrixUtils.printMatrix(sums);
        }

        private void fillSumsMatrix(int[][] matrix) {
            MatrixUtils.printMatrix(matrix);
            fillLastRow(matrix);
            MatrixUtils.printMatrix(sums);
            fillLastColumn(matrix);
            MatrixUtils.printMatrix(sums);
            fillOthers(matrix);
            MatrixUtils.printMatrix(sums);
        }

        private void fillOthers(int[][] matrix) {
            int lastColumn = matrix[0].length - 1;
            int lastRow = matrix.length - 1;
            for (int i = lastRow - 1; i >= 0; i--) {
                for (int j = lastColumn - 1; j >= 0; j--) {
                    sums[i][j] = matrix[i][j] + sums[i + 1][j] + sums[i][j + 1] - sums[i + 1][j + 1];
                }
            }
        }

        private void fillLastColumn(int[][] matrix) {
            int lastColumn = matrix[0].length - 1;
            int lastRow = matrix.length - 1;
            for (int i = lastRow - 1; i >= 0; i--) {
                sums[i][lastColumn] += sums[i + 1][lastColumn] + matrix[i][lastColumn];
            }
        }

        private void fillLastRow(int[][] matrix) {
            int lastRow = matrix.length - 1;
            int lastColumn = matrix[0].length - 1;
            sums[lastRow][lastColumn] = matrix[lastRow][lastColumn];
            for (int i = lastColumn - 1; i >= 0; i--) {
                sums[lastRow][i] += sums[lastRow][i + 1] + matrix[lastRow][i];
            }
        }

        private int getValue(int i, int j) {
            if (i > sums.length - 1) {
                return 0;
            }
            if (j > sums[0].length - 1) {
                return 0;
            }
            return sums[i][j];
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return getValue(row1, col1)
                    - getValue(row2 + 1, col1)
                    - getValue(row1, col2 + 1)
                    + getValue(row2 + 1, col2 + 1);
        }
    }
}
