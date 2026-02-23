class Solution {
    int m;
    int n;
    int x;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;
        m = image.length;
        n = image[0].length;
        x = image[sr][sc];

        if(x == color) return image;
        dfs(image, sr,sc, color);
        return image;

    }
    public void dfs(int[][] image, int i, int j, int color){
        if(i<0 || j<0 || i>m-1 || j>n-1) return;
        if(image[i][j] != x) return;

        image[i][j] = color;
        dfs(image, i+1, j, color);
        dfs(image, i, j+1, color);
        dfs(image, i-1, j, color);
        dfs(image, i, j-1, color);
    }
}