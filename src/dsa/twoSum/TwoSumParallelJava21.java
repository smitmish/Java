package dsa.twoSum;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class TwoSumParallelJava21 {
    public static int[] twoSum(int[] nums, int target) {
        ConcurrentHashMap map = new ConcurrentHashMap<>();
        AtomicReference result = new AtomicReference<>(null);

        int numThreads = Runtime.getRuntime().availableProcessors();
        int chunkSize = (nums.length + numThreads - 1) / numThreads;

        // Auto-closeable executor waits for all tasks on exit
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int t = 0; t < numThreads; t++) {
                final int start = t * chunkSize;
                final int end = Math.min(start + chunkSize, nums.length);

                executor.submit(() -> {
                    for (int i = start; i < end; i++) {
                        // Exit early if another thread already found the pair
                        if (result.get() != null) return;

                        int complement = target - nums[i];
                        if (map.containsKey(complement)) {
                            result.compareAndSet(null, new int[] { (int) map.get(complement), i });
                            return;
                        }
                        map.putIfAbsent(nums[i], i);
                    }
                });
            }
        } // Block till all virtual threads finish execution

        return result.get() != null ?(int[]) result.get() : new int[] {};
    }
    public static void main(String[] args) {
        int nums[] = {2,3,5,11};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(twoSum(nums,7)));
    }
}
