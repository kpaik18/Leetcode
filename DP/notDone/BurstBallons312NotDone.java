package DP.notDone;

import java.util.ArrayList;
import java.util.List;

public class BurstBallons312NotDone {
    public static void main(String[] args) {
        int[] nums = {1, 5};
        System.out.println(maxCoins(nums));
    }

    static public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (var next : nums) {
            list.add(next);
        }
        int result = 0;
        while (!list.isEmpty()) {
            int max = -1;
            int maxIndex = -1;
            for (int i = 0; i < list.size(); i++) {
                int current = getValue(list, i);
                if (current / list.get(i) > max) {
                    max = current / list.get(i);
                    maxIndex = i;
                }
            }
//            System.out.println(max * list.get(maxIndex));
            result += max * list.get(maxIndex);
            list.remove(maxIndex);
        }
        return result;
    }

    static private int getValue(List<Integer> nums, int i) {
        int prev = 1;
        if (i > 0) {
            prev = nums.get(i - 1);
        }
        int next = 1;
        if (i < nums.size() - 1) {
            next = nums.get(i + 1);
        }
        return nums.get(i) * prev * next;
    }
}
