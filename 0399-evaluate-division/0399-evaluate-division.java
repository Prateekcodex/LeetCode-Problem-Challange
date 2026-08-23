import java.util.*;

class Solution {

    public double[] calcEquation(
        List<List<String>> equations,
        double[] values,
        List<List<String>> queries
    ) {

        Map<String, List<Node>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            double value = values[i];

            graph
                .computeIfAbsent(a, k -> new ArrayList<>())
                .add(new Node(b, value));

            graph
                .computeIfAbsent(b, k -> new ArrayList<>())
                .add(new Node(a, 1.0 / value));
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) ||
                !graph.containsKey(end)) {

                result[i] = -1.0;
                continue;
            }

            if (start.equals(end)) {
                result[i] = 1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();

            result[i] = dfs(
                start,
                end,
                1.0,
                graph,
                visited
            );
        }

        return result;
    }

    private double dfs(
        String current,
        String target,
        double value,
        Map<String, List<Node>> graph,
        Set<String> visited
    ) {

        if (current.equals(target)) {
            return value;
        }

        visited.add(current);

        for (Node neighbor : graph.get(current)) {

            if (visited.contains(neighbor.name)) {
                continue;
            }

            double result = dfs(
                neighbor.name,
                target,
                value * neighbor.value,
                graph,
                visited
            );

            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;
    }

    class Node {
        String name;
        double value;

        Node(String name, double value) {
            this.name = name;
            this.value = value;
        }
    }
}