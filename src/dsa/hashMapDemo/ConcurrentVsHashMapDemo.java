package dsa.hashMapDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class ConcurrentVsHashMapDemo {

    public static void main(String[] args) {
        int total = 10000;

        // --- 1. Testing Regular HashMap ---
        Map unsafeMap = new HashMap<>();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < total; i++) {
                final int val = i;
                executor.submit(() -> unsafeMap.put(val, val));
            }
        } // Wait for all virtual threads to finish

        System.out.println("Expected size : " + total);
        System.out.println("HashMap size  : " + unsafeMap.size());

        // Find missing keys programmatically
        List missingKeys = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            if (unsafeMap.containsKey(i)) {
                missingKeys.add(i);
            }
        }

        System.out.println("\nTotal values missed in HashMap: " + missingKeys.size());
        System.out.println("First 10 missed values: " +
                missingKeys.subList(0, Math.min(10, missingKeys.size())));

        // --- 2. Testing ConcurrentHashMap ---
        Map safeMap = new ConcurrentHashMap<>();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < total; i++) {
                final int val = i;
                executor.submit(() -> safeMap.put(val, val));
            }
        }

        System.out.println("\nConcurrentHashMap size: " + safeMap.size());

        // Verification loop for ConcurrentHashMap
        int safeMisses = 0;
        for (int i = 0; i < total; i++) {
            if (!safeMap.containsKey(i)) safeMisses++;
        }
        System.out.println("Total values missed in ConcurrentHashMap: " + safeMisses);
    }
}