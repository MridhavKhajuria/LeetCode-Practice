class Solution {
    public int maxProfit(int[] prices) {
        int l =0, r =1;
        int sum = 0;
        while(l < prices.length && r < prices.length){
            if(prices[l]<prices[r]){
                sum += prices[r] - prices[l];
                l++;
                r++;
            }
            else{
                l++;
                r++;
            }
        }
        return sum;
    }
}