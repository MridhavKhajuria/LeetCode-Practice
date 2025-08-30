class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int i=g.length-1, j=s.length-1;
        while(i>=0 && j>=0){
            if(g[i] <= s[j]){
                cnt++;
                i--;
                j--;
            }
            else{
                i--;
                // j++;
            }
        }
        return cnt;
    }
}