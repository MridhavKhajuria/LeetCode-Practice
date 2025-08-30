class Solution {
    List<String> result = new ArrayList<>();
    
    private void solve(String current, int open, int close, int n){
        if(current.length() == 2*n){
            result.add(current);
            return;
        }

        if(open < n){
            solve(current + "(", open + 1, close, n);
        }
        if(close < open){
            solve(current + ")", open, close+1, n);
        }
    }
    public List<String> generateParenthesis(int n) {
        solve("", 0, 0, n);
        return result;
    }
}