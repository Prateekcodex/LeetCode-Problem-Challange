class Solution {
    private boolean[][] pal;
    private int[] dp;
    private int n;
    private int k;

    public int maxPalindromes(String s, int k) {
        n = s.length();
        this.k = k;

        pal = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            pal[i][i] = true;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || pal[i + 1][j - 1]) {
                        pal[i][j] = true;
                    }
                }
            }
        }

        dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
        
            dp[i] = dp[i + 1];
 
            for (int j = i + k - 1; j < n; j++) {
                if (pal[i][j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}