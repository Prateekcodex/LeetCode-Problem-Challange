import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        // Store indices of each party
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {

            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {
                // Radiant senator acts first
                radiant.offer(r + n);
            } else {
                // Dire senator acts first
                dire.offer(d + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}