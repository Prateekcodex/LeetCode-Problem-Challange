class Solution {
    public int surfaceArea(int[][] grid) {

        int area = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int height = grid[i][j];

                if (height == 0) {
                    continue;
                }

                // Top and bottom
                area += 2;

                // Front
                area += Math.max(0, height - (i > 0 ? grid[i - 1][j] : 0));

                // Back
                area += Math.max(0, height - (i < n - 1 ? grid[i + 1][j] : 0));

                // Left
                area += Math.max(0, height - (j > 0 ? grid[i][j - 1] : 0));

                // Right
                area += Math.max(0, height - (j < n - 1 ? grid[i][j + 1] : 0));
            }
        }

        return area;
    }
}