import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = Integer.MIN_VALUE;

        for (int[] interval : intervals) {

            if (interval[0] >= end) {
                end = interval[1];
            } else {
                count++;
            }
        }

        return count;
    }
}