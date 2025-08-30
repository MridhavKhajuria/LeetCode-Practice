class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, subset, result);
        return result;
    }

    public void backtrack(int i, int[] nums, List<Integer> subset, List<List<Integer>> result){
        if(i == nums.length) {
        result.add(new ArrayList<>(subset));
        return;
        }

        subset.add(nums[i]);
        backtrack(i + 1, nums, subset, result);
        subset.remove(subset.size() - 1);

        while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;

        backtrack(i + 1, nums, subset, result);
    }
}