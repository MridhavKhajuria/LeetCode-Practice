class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), 0, candidates, target, result);
        return result;
    }
    private void backtrack(List<Integer> curr, int index, int[] candidates, int target,List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i<candidates.length; i++){
            if(i>index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;

            curr.add(candidates[i]);
            backtrack(curr, i+1, candidates, target-candidates[i], result);
            curr.remove(curr.size()-1);
        }
    }
}