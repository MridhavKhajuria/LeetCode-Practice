class Solution {
    int m;
    int n;
    int max;
    int count;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        max = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    count = 0;
                    dfs(grid, i, j, max);
                    if(count>max) max = count;
                }
            }
        }
        return max;
    }
    public void dfs(int[][] grid, int i, int j, int max){
        if(i<0 || j<0 || i>m-1 || j>n-1) return;
        if(grid[i][j] == 0) return;
        count++;
        grid[i][j] = 0;
        dfs(grid, i+1, j, max);
        dfs(grid, i, j+1, max);
        dfs(grid, i-1, j, max);
        dfs(grid, i, j-1, max);

    }
}