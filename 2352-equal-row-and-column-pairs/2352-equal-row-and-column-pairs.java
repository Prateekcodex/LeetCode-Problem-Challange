import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {

        int n = grid.length;

        HashMap<String, Integer> map = new HashMap<>();

        // Store frequency of each row
        for (int i = 0; i < n; i++) {

            StringBuilder row = new StringBuilder();

            for (int j = 0; j < n; j++) {
                row.append(grid[i][j]).append("#");
            }

            String key = row.toString();

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int result = 0;

        // Check each column
        for (int j = 0; j < n; j++) {

            StringBuilder column = new StringBuilder();

            for (int i = 0; i < n; i++) {
                column.append(grid[i][j]).append("#");
            }

            String key = column.toString();

            result += map.getOrDefault(key, 0);
        }

        return result;
    }
}