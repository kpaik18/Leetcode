package DP;

import java.util.HashMap;
import java.util.Map;

public class TargetSum494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 0}, 1));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        findTargets(nums, 0, memo);
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        return 0;
    }

    private static void findTargets(int[] nums,
                                    int index,
                                    Map<Integer, Integer> memo) {
        if (index == nums.length - 1) {
            Map<Integer, Integer> m;
            if (nums[index] == 0) {
                m = Map.of(0, 2);
            } else {
                m = Map.of(nums[index], 1, -nums[index], 1);
            }
            memo.putAll(m);
            return;
        }
        if (!memo.containsKey(index + 1)) {
            findTargets(nums, index + 1, memo);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int next = nums[index];
        for (var key : memo.keySet()) {
            int count = memo.get(key);
            int a = key + next;
            int b = key - next;
            if (!map.containsKey(a)) {
                map.put(a, 0);
            }
            if (!map.containsKey(b)) {
                map.put(b, 0);
            }
            map.put(a, count + map.get(a));
            map.put(b, count + map.get(b));
        }
        memo.clear();
        memo.putAll(map);
    }
}
