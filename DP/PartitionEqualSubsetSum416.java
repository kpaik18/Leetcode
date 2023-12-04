package DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));
    }


    public static boolean canPartition(int[] nums) {
        int sum = sumUp(nums);
        if (sum % 2 == 1) {
            return false;
        }
        Map<Integer, Set<Integer>> indexPossibleTarget = new HashMap<>();

        return canGetTarget(nums, sum / 2, 0, indexPossibleTarget);
    }


    private static boolean canGetTarget(int[] nums, int target, int index, Map<Integer, Set<Integer>> indexPossibleTarget) {
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        if (indexPossibleTarget.containsKey(index)) {
            if (indexPossibleTarget.get(index).contains(target)) {
                return true;
            }
            if (indexPossibleTarget.get(index).contains(-target)) {
                return false;
            }
        }
        int num = nums[index];
        boolean right = canGetTarget(nums, target - num, index + 1, indexPossibleTarget);
        boolean left = canGetTarget(nums, target, index + 1, indexPossibleTarget);
        if (!indexPossibleTarget.containsKey(index)) {
            indexPossibleTarget.put(index, new HashSet<>());
        }
        if (left || right) {
            indexPossibleTarget.get(index).add(target);
        } else {
            indexPossibleTarget.get(index).add(-target);
        }
        return left || right;
    }

    private static int sumUp(int[] nums) {
        int sum = 0;
        for (var next : nums) {
            sum += next;
        }
        return sum;
    }
}
