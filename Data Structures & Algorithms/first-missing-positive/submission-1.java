class Solution {
    public int firstMissingPositive(int[] nums) {
        // Optimal Solution
        // int n = nums.length;
        // for(int i = 0; i < n; i++){
        //     while(nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
        //         int temp = nums[i];
        //         nums[i] = nums[temp - 1];
        //         nums[temp - 1] = temp;
        //     }
        // }
        // for(int i = 0; i < n; i++){
        //     if(nums[i] != i + 1){
        //         return i + 1;
        //     }
        // }
        // return n + 1;
        // Using sorting
        Arrays.sort(nums);
        int missing = 1;
        for(int num : nums){
            if(num > 0 && missing == num){
                missing++;
            }
        }
        return missing;
    }
}