package dsa.hashMapDemo;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap<>();

        // putIfAbsent guarantees atomic check-and-act:
        // Reads value, and puts "Alice" -> 10 ONLY if "Alice" is missing.
        map.putIfAbsent("Alice", 10);
        map.putIfAbsent("Alice", 20); // Ignored because "Alice" exists

        System.out.println(map.get("Alice")); // Prints 10

        HashMap normalHashMap = new HashMap<>();

        // putIfAbsent guarantees atomic check-and-act:
        // Reads value, and puts "Alice" -> 10 ONLY if "Alice" is missing.
        normalHashMap.putIfAbsent("Alice", 10);
        normalHashMap.putIfAbsent("Alice", 20); // Ignored because "Alice" exists

        System.out.println(normalHashMap.get("Alice"));


    }
}