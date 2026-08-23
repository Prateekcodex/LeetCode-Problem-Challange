import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices by nums2 in descending order
        Arrays.sort(indices, (a, b) ->
            Integer.compare(nums2[b], nums2[a])
        );

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long sum = 0;
        long answer = 0;

        for (int i = 0; i < n; i++) {

            int index = indices[i];

            sum += nums1[index];
            minHeap.offer(nums1[index]);

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                answer = Math.max(
                    answer,
                    sum * nums2[index]
                );
            }
        }

        return answer;
    }
}