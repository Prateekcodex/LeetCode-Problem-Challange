class Solution {
    public int minFlips(int a, int b, int c) {

        int flips = 0;

        while (a > 0 || b > 0 || c > 0) {

            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            int orResult = bitA | bitB;

            if (orResult != bitC) {

                if (bitC == 1) {
                    // Both a and b are 0, so flip either one
                    flips++;
                } else {
                    // c = 0, so every 1 in a and b must be flipped
                    flips += bitA + bitB;
                }
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}