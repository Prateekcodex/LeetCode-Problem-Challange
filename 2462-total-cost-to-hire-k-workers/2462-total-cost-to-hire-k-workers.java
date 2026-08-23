import java.util.*;

class Solution {
    public long totalCost(
        int[] costs,
        int k,
        int candidates
    ) {

        PriorityQueue<Integer> left =
            new PriorityQueue<>();

        PriorityQueue<Integer> right =
            new PriorityQueue<>();

        int n = costs.length;

        int l = 0;
        int r = n - 1;

        // Fill left heap
        while (l <= r &&
               left.size() < candidates) {

            left.offer(costs[l]);
            l++;
        }

        // Fill right heap
        while (l <= r &&
               right.size() < candidates) {

            right.offer(costs[r]);
            r--;
        }

        long answer = 0;

        for (int i = 0; i < k; i++) {

            if (right.isEmpty() ||
                (!left.isEmpty() &&
                 left.peek() <= right.peek())) {

                answer += left.poll();

                if (l <= r) {
                    left.offer(costs[l]);
                    l++;
                }

            } else {

                answer += right.poll();

                if (l <= r) {
                    right.offer(costs[r]);
                    r--;
                }
            }
        }

        return answer;
    }
}