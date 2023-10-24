package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PerfectSquares279 {
    private static List<Integer> squares = getSquares(100);
    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(numSquares(51));
    }

    public static int numSquares(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n <= 1) {
            return n;
        }
        int index = find(squares, n);
        int result = Integer.MAX_VALUE;
        for (int i = index; i >= 0; i--) {
            int next = squares.get(i);
            result = Math.min(result, numSquares(n - next) + 1);
        }
        memo.put(n, result);
        return result;
    }

    private static int find(List<Integer> squares, int n) {
        for (int i = 0; i < squares.size(); i++) {
            int next = squares.get(i);
            if (next > n) {
                return i - 1;
            }
        }
        return squares.size() - 1;
    }

    private static List<Integer> getSquares(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(i * i);
        }
        return result;
    }
}
