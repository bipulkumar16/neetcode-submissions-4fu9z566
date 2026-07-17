class Solution {
    public int maxProfit(int[] prices) {
        // Solution 1
        // int left = 0, maxProfit = 0;
        // for(int right = 1; right < prices.length; right++){
        //     if(prices[left] < prices[right]){
        //         maxProfit = Math.max(maxProfit, prices[right] - prices[left]);   
        //     } else {
        //         left = right;
        //     }
        // }
        // return maxProfit;
        // Solution 2
        int maxProfit = 0, minProfit = Integer.MAX_VALUE;
        for(int price : prices){
            minProfit = Math.min(price, minProfit);
            maxProfit = Math.max(maxProfit, price - minProfit);
        }
        return maxProfit;
    }
}
