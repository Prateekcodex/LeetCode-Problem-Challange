import java.util.*;

class Solution {

    public int minReorder(int n, int[][] connections) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {

            int from = connection[0];
            int to = connection[1];

            // Original direction: from -> to
            graph[from].add(new int[]{to, 1});

            // Reverse traversal: to -> from
            graph[to].add(new int[]{from, 0});
        }

        boolean[] visited = new boolean[n];

        return dfs(0, graph, visited);
    }

    private int dfs(
        int city,
        List<int[]>[] graph,
        boolean[] visited
    ) {

        visited[city] = true;

        int changes = 0;

        for (int[] edge : graph[city]) {

            int nextCity = edge[0];
            int needsReversal = edge[1];

            if (visited[nextCity]) {
                continue;
            }

            changes += needsReversal;

            changes += dfs(
                nextCity,
                graph,
                visited
            );
        }

        return changes;
    }
}