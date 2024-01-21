package DP.notDone;

import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes354DoAtHome {
    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{
                {1, 3},
                {3, 5},
                {6, 7},
                {6, 8},
                {8, 4},
                {9, 5}
        }));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        List<int[]> sortedByZero = sortByIndex(envelopes);
        sortedByZero.forEach(a -> System.out.println("{" + a[0] + " - " + a[1] + "}"));
        return lis(sortedByZero);
    }

    private static int lis(List<int[]> sortedByZero) {
        int result = 1;
        int lastIndex = 0;
        int size = sortedByZero.size();
        while (true) {
            int left = lastIndex + 1;
            int right = size - 1;
            int[] last = sortedByZero.get(lastIndex);
            int foundIndex = -1;
            while (left <= right) {
                int middle = (left + right) / 2;
                int[] check = sortedByZero.get(middle);
                if (contains(last, check)) {
                    right = middle - 1;
                    foundIndex = middle;
                } else {
                    left = middle + 1;
                }
            }
            if (foundIndex == -1) {
                return result;
            }
            lastIndex = foundIndex;
            result++;
        }
    }

    private static boolean contains(int[] first, int[] second) {
        return second[0] < first[0] && second[1] < first[1];
    }

    private static List<int[]> sortByIndex(int[][] envelopes) {
        return Arrays.stream(envelopes).sorted((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        }).toList();
    }

}
