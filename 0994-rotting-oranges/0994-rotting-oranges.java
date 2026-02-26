class Solution {
    int m;
    int n;
    int minute;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        minute = 0;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0;

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotten = false;

            for(int k = 0; k<size; k++){
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];

                for(int[] d : dir){
                    int ni = i + d[0];
                    int nj = j + d[1];
                    
                    if(ni >= 0 && nj >= 0 && ni<m && nj<n && grid[ni][nj] == 1){
                        grid[ni][nj] = 2;
                        queue.offer(new int[]{ni, nj});
                        fresh--;
                        rotten=true;
                    }
                }
            }
            if(rotten) minute++;
        }
        return fresh == 0 ? minute : -1;
    }
}