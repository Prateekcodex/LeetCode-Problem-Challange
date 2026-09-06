class Solution {
    public int numDistinct(String s, String t) {
        int n = t.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (char ch : s.toCharArray()) {
            for (int j = n; j >= 1; j--) {
                if (ch == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n];
    }
}
