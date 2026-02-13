class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> mao = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            mao.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            mao.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(source, destination, mao, visited);

    }

    private boolean dfs(int node, int destination, Map<Integer, List<Integer>> mao, Set<Integer> visited) {
        if (node == destination)
            return true;
        visited.add(node);
        for (int neighbor : mao.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, destination, mao, visited))
                    return true;
            }
        }
        return false;
    }
}