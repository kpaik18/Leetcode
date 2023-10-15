package DP;

import java.util.HashMap;

public class DecodeWays91 {


    private static int[] result = new int[1];

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }

    public static int numDecodings(String s) {
        HashMap<String, Integer> memo = new HashMap<>();
        memo.put("", 1);
        memo.put("0", 0);
        for (int i = 1; i <= 9; i++) {
            char ch = (char) ((int) '0' + i);
            memo.put("" + ch, 1);
        }
        System.out.println(memo);
        return helper(s, memo);
    }

    private static int helper(String s, HashMap<String, Integer> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        String first = s.substring(0, 1);
        String second = s.substring(0, 2);
        int result = 0;
        if (isValid(first)) {
            result += helper(s.substring(1), memo);
        }
        if (isValid(second)) {
            result += helper(s.substring(2), memo);
        }
        memo.put(s, result);
        return result;
    }

    private static boolean isValid(String s) {
        if (s.startsWith("0")) {
            return false;
        }
        int num = Integer.parseInt(s);
        return num > 0 && num <= 26;
    }


}
