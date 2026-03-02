class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int[] p : prerequisites) adj.get(p[1]).add(p[0]);

        int vis[] = new int[numCourses];
        
        for(int i = 0; i<numCourses; i++){
            if(vis[i] == 0) if(topo(i, adj, vis)) return false;
        }
        return true;
    }
    private boolean topo(int node, List<List<Integer>> adj, int[] vis){
        vis[node] = 1;

        for(int k : adj.get(node)){
            if(vis[k] == 1) return true;
            if(vis[k] == 0) if(topo(k, adj, vis)) return true;
        }
        vis[node] = 2;
        return false;
    }
}