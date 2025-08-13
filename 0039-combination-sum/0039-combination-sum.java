class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(new ArrayList<>(),0,0,candidates, target);
        return result;
    }
    private void backtrack(List<Integer> curr, int start ,int sum, int []candidates, int target){
        if(sum == target){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(sum > target) return;
        for(int i = start; i<candidates.length; i++){
            curr.add(candidates[i]);
            backtrack(curr, i ,sum+candidates[i], candidates, target);
            curr.remove(curr.size()-1);
        }
    }
}