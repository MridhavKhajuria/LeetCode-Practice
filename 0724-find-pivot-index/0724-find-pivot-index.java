class Solution {
    public int pivotIndex(int[] nums) {
        int maxSum = 0;
        for(int num : nums){
            maxSum += num;
        }
        int leftSum = 0;
        for(int i = 0; i<nums.length; i++){
            int rightSum = maxSum - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}