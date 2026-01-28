class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = -1;
        int[] arr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,arr,0, nums1.length);
        System.arraycopy(nums2,0,arr,nums1.length, nums2.length);
        Arrays.sort(arr);
        if(arr.length%2 == 0){
            int mid = (arr.length)/2 - 1;
            ans = ((double)arr[mid]+arr[mid+1])/2;
        }
        else {
            ans = arr[arr.length/2];
        }
        return ans;
    }
}