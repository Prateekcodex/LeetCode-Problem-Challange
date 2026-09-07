class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;

        long[] dp = new long[26];

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';

            long total = 1;

            for (long count : dp) {
                total = (total + count) % MOD;
            }

            dp[index] = total;
        }

        long answer = 0;

        for (long count : dp) {
            answer = (answer + count) % MOD;
        }

        return (int) answer;
    }
}
