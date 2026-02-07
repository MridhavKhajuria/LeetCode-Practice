class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i = 0; i<numCourses; i++){
            if(!vis[i]){
                if(dfs(i, adj, vis, path)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int curr,List<List<Integer>> adj, boolean[] vis, boolean[] path){
        vis[curr] = true;
        path[curr] = true;

        for(int next : adj.get(curr)){
            if(!vis[next]){
                if(dfs(next, adj, vis, path)) return true;
            }
            else if(path[next]) return true;
        }

        path[curr] = false;
        return false;
    }
}