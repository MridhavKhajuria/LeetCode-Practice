class Solution {
    int m;
    int n;
    int cnt;
    boolean[][] vis;
    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        cnt = 0;
        vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return cnt;
                }
            }
        }
        return cnt;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1) {
            cnt++;
            return;
        }

        if(grid[i][j] == 0){
            cnt++;
            return;
        }

        if(vis[i][j]) return;
        vis[i][j] = true;
        
        dfs(grid, i+1 , j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
}