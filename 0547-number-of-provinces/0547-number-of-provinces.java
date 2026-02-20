class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int provinces = 0;
        for(int c = 0; c < n; c++){
            if(!visited[c]) {
                dfs(c, isConnected, visited, n);
                provinces++;
            }
        }
        return provinces;
    }
    private void dfs(int node, int[][] isConnected, boolean[] visited, int n){
        visited[node] = true;

        for(int i = 0; i < n; i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                dfs(i, isConnected, visited, n);
            }
        }
    }
}