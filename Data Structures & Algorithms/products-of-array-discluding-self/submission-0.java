class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Brute force
        // int n = nums.length;
        // int[] product = new int[n];

        // for(int i = 0; i < n; i++){
        //     int prod = 1;
        //     for(int j = 0; j < n; j++){
        //         if(i != j){
        //             prod *= nums[j];
        //         }
        //     }
        //     product[i] = prod;
        // }
        // return product;
        // Prefix (Optimal Solution)
        int n = nums.length;
        int[] product = new int[n];

        product[0] = 1;
        for(int i = 1; i < n; i++){
            product[i] = product[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for(int i = n - 1; i >= 0; i--){
            product[i] *= postfix;
            postfix *= nums[i];
        }
        return product;
    }
}  
