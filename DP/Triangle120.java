package DP;

import java.util.HashMap;
import java.util.List;

public class Triangle120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle =
                List.of(
                        List.of(2),
                        List.of(3, 4),
                        List.of(6, 5, 6),
                        List.of(4, 1, 8, 3)
                );
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int lastRowIndex = triangle.size() - 1;
        List<Integer> lastRow = triangle.get(lastRowIndex);
        int multiplier = lastRow.size();
        for (int i = 0; i < lastRow.size(); i++) {
            memo.put(lastRowIndex * multiplier + i, lastRow.get(i));
        }
        return helper(triangle, 0, 0, memo);
    }

    private static int helper(List<List<Integer>> triangle, int i, int j, HashMap<Integer, Integer> memo) {
        int multiplier = triangle.get(triangle.size() - 1).size();
        if (memo.containsKey(i * multiplier + j)) {
            return memo.get(i * multiplier + j);
        }
        int result = triangle.get(i).get(j) + Math.min(
                helper(triangle, i + 1, j, memo),
                helper(triangle, i + 1, j + 1, memo)
        );
        memo.put(i * multiplier + j, result);
        return result;
    }
}
