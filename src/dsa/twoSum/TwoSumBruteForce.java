package dsa.twoSum;

import java.util.Arrays;

public class TwoSumBruteForce {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        int nums[] = {2,3,5,11};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(twoSum(nums,7)));
    }
}
