class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int n = nums.length-1;
        int l = 0, r = nums.length-1;
        if(nums[0]>nums[1]) return 0;
        if(nums[n]>nums[n-1]) return n;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) 
                return mid;
            else if(nums[mid]>nums[mid+1] && nums[mid]<nums[mid-1])
                r = mid-1;
            else l = mid+1;
        }
        return -1;
    }
}