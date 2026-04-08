class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % k != 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        reverse(nums);
        int[] bucket = new int[k];
        return backtrack(nums, 0, bucket, target);
    }
    private boolean backtrack(int[] nums, int index, int[] bucket, int target){
        if(index == nums.length) return true;
        int num = nums[index];
        for(int i = 0; i < bucket.length; i++){
            if(bucket[i] + num > target) continue;
            bucket[i] += num;
            if(backtrack(nums, index + 1, bucket, target)) return true;
            bucket[i] -= num;
            if(bucket[i] == 0) break;
        }
        return false;
    }
    private void reverse(int[] nums){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}