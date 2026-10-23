class Solution {
    public int maxProfit(int[] prices) {
        // int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        // for(int price : prices){
        //     minPrice = Math.min(minPrice, price);
        //     maxProfit = Math.max(maxProfit, price - minPrice);
        // }
        // return maxProfit;
        int left = 0, maxProfit = 0, right = 1;
        while(right < prices.length){
            if(prices[left] < prices[right]){
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(profit, maxProfit);
            } else left = right;
            right++;

        }
        return maxProfit;
    }
}
