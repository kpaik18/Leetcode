package DP;

import java.util.HashMap;

public class PalindromePartitioning132 {
    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        memo.clear();
        System.out.println(minCut("eeb"));
    }


    public static int minCut(String s) {
        return helper(s);
    }

    private static int helper(String s) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.equals("")) {
            return 0;
        }
        if (isPalindrome(s)) {
            memo.put(s, 0);
            return 0;
        }
        int minCount = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s.substring(i))) {
                int tmp = helper(s.substring(0, i));
                if (tmp + 1 < minCount) {
                    minCount = tmp + 1;
                }
            }
        }
        memo.put(s, minCount);
        return minCount;
    }

    private static boolean isPalindrome(String tmp) {
        if (tmp.length() <= 1) {
            return true;
        }
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) != tmp.charAt(tmp.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
