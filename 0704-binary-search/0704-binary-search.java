class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length - 1, low = 0;
        int mid = (low + high)/2;
        if(nums[low] == target) return low;
        if(nums[high] == target) return high;

        while(low <= high){
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) {
                low = mid + 1;
                mid = (low + high)/2;
            }
            else {
                high = mid - 1;
                mid = (low + high)/2;
            }
        }
        return -1;
    }
}