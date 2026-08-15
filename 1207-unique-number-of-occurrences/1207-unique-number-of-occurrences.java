import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> frequencies = new HashSet<>();

        // Check if frequencies are unique
        for (int count : map.values()) {

            if (frequencies.contains(count)) {
                return false;
            }

            frequencies.add(count);
        }

        return true;
    }
}