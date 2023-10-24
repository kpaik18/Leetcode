package DP;

public class MaximalSquare221 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1'}
        };
//        MatrixUtils.printMatrix(matrix);
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int min = Math.min(rowCount, colCount);
        int a = findMaximalSquare(1, min, min, matrix);
        if (a <= 0) {
            return 0;
        }
        return a * a;
    }

    private static int findMaximalSquare(int start, int end, int maxSquareSize, char[][] matrix) {
        int size = start + (end - start) / 2;
        if (size <= 0 || size > maxSquareSize || end < start) {
            return -1;
        }
        int max = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isPossible(i, j, size, matrix)) {
                    max = Math.max(max, checkMaxSquare(matrix, i, j, size));
                }
            }
        }
        if (max == -1) {
            return findMaximalSquare(start, size - 1, maxSquareSize, matrix);
        }
        return Math.max(max, findMaximalSquare(size + 1, end, maxSquareSize, matrix));
    }

    private static int checkMaxSquare(char[][] matrix, int i, int j, int size) {
        for (int k = i; k < i + size; k++) {
            for (int z = j; z < j + size; z++) {
                if (matrix[k][z] == '0') {
                    return -1;
                }
            }
        }
        return size;
    }

    private static boolean isPossible(int i, int j, int size, char[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        if (i + size > h) {
            return false;
        }
        if (j + size > w) {
            return false;
        }
        return true;
    }


}
