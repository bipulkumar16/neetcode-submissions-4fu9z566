class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int prefixSum = 0;
            for(int j = i; j < nums.length; j++){
                prefixSum += nums[j];
                if(prefixSum == k) count++;
            }
        }
        return count;
    }
}