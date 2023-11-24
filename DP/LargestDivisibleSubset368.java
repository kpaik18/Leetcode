package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset368 {
    public static void main(String[] args) {
        largestDivisibleSubset(new int[]{2, 3});
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int[] parents = new int[nums.length];
        int[] lis = new int[nums.length];
        lis[lis.length - 1] = 1;
        parents[parents.length - 1] = parents.length - 1;
        int maxIndex = 0;
        int max = -1;
        for (int i = lis.length - 2; i >= 0; i--) {
            int current = nums[i];
            lis[i] = 1;
            parents[i] = i;
            for (int j = i + 1; j < lis.length; j++) {
                int next = nums[j];
                if (next % current == 0) {
                    if (lis[j] + 1 > lis[i]) {
                        lis[i] = lis[j] + 1;
                        parents[i] = j;
                        if (lis[i] > max) {
                            max = lis[i];
                            maxIndex = i;
                        }
                    }
                }
            }
        }

        return getSubset(nums, parents, maxIndex);
    }

    private static List<Integer> getSubset(int[] nums, int[] parents, int maxIndex) {
        List<Integer> result = new ArrayList<>();
        int current = maxIndex;
        while (parents[current] != current) {
            result.add(nums[current]);
            current = parents[current];
        }
        result.add(nums[current]);
        return result;
    }


}
