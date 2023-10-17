package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePartitioning131 {

    static HashMap<String, List<String>> memo = new HashMap<>();

    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        String s = "abba";
        List<String> choice = new ArrayList<>();
        helper(s, choice);
    }

    private static void helper(String s, List<String> choice) {
        if (s.equals("")) {
            return;
        }
        if (isPalindrome(s)) {
            choice.add(s);
            printList(choice);
            choice.remove(choice.size() - 1);
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (isPalindrome(sub)) {
                choice.add(sub);
                helper(s.substring(i + 1), choice);
                choice.remove(choice.size() - 1);
            }
        }
    }

    private static void printList(List<String> list) {
        for (var elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
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