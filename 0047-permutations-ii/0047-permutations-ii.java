class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtract(new ArrayList<>(), new boolean[nums.length], nums);
        return result;
    }
    private void backtract(List<Integer> curr, boolean[] valid, int[] nums){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if (valid[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !valid[i-1]) continue;
            valid[i] = true;
            curr.add(nums[i]);
            backtract(curr, valid, nums);
            curr.remove(curr.size() - 1); // backtrack step
            valid[i] = false;
        }
    }
}