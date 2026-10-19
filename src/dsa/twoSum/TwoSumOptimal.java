package dsa.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumOptimal {
    public static int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {(int) map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        int nums[] = {2,3,5,11};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(twoSum(nums,7)));
    }
}
