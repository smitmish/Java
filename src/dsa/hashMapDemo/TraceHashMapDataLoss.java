package dsa.hashMapDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;

public class TraceHashMapDataLoss {
    public static void main(String[] args) {
        int total = 10000;
        Map unsafeMap = new HashMap<>();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < total; i++) {
                final int val = i;
                executor.submit(() -> unsafeMap.put(val, val));
            }
        } // Waits for all virtual threads to complete

        // Step 1: Read corrupted internal counter
        int reportedSize = unsafeMap.size();

        // Step 2: Manually count actual present and missing keys across [0 ... 9999]
        int actualPresentCount = 0;
        List missingKeys = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            if (unsafeMap.containsKey(i)) {
                actualPresentCount++;
            } else {
                missingKeys.add(i);
            }
        }

        // Output breakdown
        System.out.println("=== HashMap Concurrency Diagnostics ===");
        System.out.println("1. Total Attempted Inserts      : " + total);
        System.out.println("2. HashMap.size() Field Value   : " + reportedSize + " (Corrupted size++ counter)");
        System.out.println("3. Actual Keys Found in Map     : " + actualPresentCount);
        System.out.println("4. Actual Missing Keys Count    : " + missingKeys.size());
        System.out.println("---------------------------------------");
        System.out.println("Verification (actualPresentCount + missingKeys.size()): " + (actualPresentCount + missingKeys.size()));

        System.out.println("\nSize Counter Corruption Loss  : " + (total - reportedSize));
        System.out.println("First 10 Missed Values          : " +
                missingKeys.subList(0, Math.min(10, missingKeys.size())));
    }
}
