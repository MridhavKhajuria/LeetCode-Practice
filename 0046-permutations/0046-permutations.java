class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>() , new boolean[nums.length], nums);
        return result;
    }
    private void backtrack(List<Integer> curr, boolean[] used, int[] nums){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(!used[i]){
                used[i] = true;
                curr.add(nums[i]);
                backtrack(curr, used, nums);

                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
}