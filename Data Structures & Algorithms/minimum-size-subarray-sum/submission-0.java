class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, res = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                res = Math.min(right - left + 1, res);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}