package DP;

public class CountNumbersWithUniqueDigits357 {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += getNDigitUniques(i);
        }
        return result + 1;
    }

    private static int getNDigitUniques(int n) {
        System.out.println(n);
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 9;
        }
        int res = 9;
        for (int i = 0; i < n - 1; i++) {
            res *= (9 - i);
        }
        return res;
    }
}
