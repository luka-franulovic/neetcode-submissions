class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int l = 0;
        int r = 1;
        int maxProfit = 0;
        while (r < prices.length){
            if (prices[r] - prices[l] >= 0){ 
                maxProfit = Math.max(prices[r] - prices[l], maxProfit);
                r++;
            }
            else l++;
 
        }
        return maxProfit;
    }
}
