class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Maximum pile is the maximum possible speed
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                // Speed is enough, try smaller
                right = mid;
            } else {
                // Speed is too slow
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(
        int[] piles,
        int h,
        int speed
    ) {

        long hours = 0;

        for (int pile : piles) {

            hours += (pile + speed - 1) / speed;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}