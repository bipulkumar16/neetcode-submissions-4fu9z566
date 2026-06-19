class Solution {
    public int maxProduct(int[] nums) {
        // Brute Force
        // int maxProduct = nums[0];
        // for(int i = 0; i < nums.length; i++){
        //     int product = 1;
        //     for(int j = i; j < nums.length; j++){
        //         product *= nums[j];
        //         maxProduct = Math.max(product, maxProduct);
        //     }
        // }
        // return maxProduct;
        // Optimal Solution
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            if(curr < 0){
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }
            maxEndingHere = Math.max(curr, maxEndingHere * curr);
            minEndingHere = Math.min(curr, minEndingHere * curr);
            result = Math.max(result, maxEndingHere);
        }
        return result;
    }
}
