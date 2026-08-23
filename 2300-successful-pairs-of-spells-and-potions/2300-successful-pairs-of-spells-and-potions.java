import java.util.*;

class Solution {
    public int[] successfulPairs(
        int[] spells,
        int[] potions,
        long success
    ) {

        Arrays.sort(potions);

        int[] answer = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {

            long required =
                (success + spells[i] - 1) / spells[i];

            int index = lowerBound(potions, required);

            answer[i] = potions.length - index;
        }

        return answer;
    }

    private int lowerBound(int[] potions, long target) {

        int left = 0;
        int right = potions.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (potions[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}