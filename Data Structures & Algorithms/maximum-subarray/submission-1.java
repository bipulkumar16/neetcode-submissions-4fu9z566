class Solution {
    public int maxSubArray(int[] nums) {
        // Brute Force
        // int maxSum = nums[0];
        // for(int i = 0; i < nums.length; i++){
        //     int sum = 0;
        //     for(int j = i; j < nums.length; j++){
        //         sum += nums[j];   
        //         maxSum = Math.max(sum, maxSum); 
        //     }    
        // }
        // return maxSum;
        // Optimal Solution
        int maxSum = nums[0];
        int sum = 0;
        for(int num : nums){
            sum += num;
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}
