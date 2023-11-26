package DP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSumIV377 {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        helper(nums, target, memo);
        return memo.get(target);
    }

    private static int helper(int[] nums, int target, Map<Integer, Integer> memo) {
        if(target == 0){
            return 1;
        }
        if(target < 0){
            return -1;
        }
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        int count = 0;

        for(var next : nums){
            int res = helper(nums, target - next, memo);
            if(res != -1){
                count += res;
            }
        }
        memo.put(target, count);
        return count;
    }

    private static void putInMap(Map<Integer, Integer> map, int num){
        if(!map.containsKey(num)){
            map.put(num, 0);
        }
        map.put(num, map.get(num) + 1);
    }
}
