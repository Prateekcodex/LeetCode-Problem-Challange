class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int[] count = new int[n + 1];

        for (int citation : citations) {
            count[Math.min(citation, n)]++;
        }

        int papers = 0;

        for (int h = n; h >= 0; h--) {
            papers += count[h];

            if (papers >= h) {
                return h;
            }
        }

        return 0;
    }
}