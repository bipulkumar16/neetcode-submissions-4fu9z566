class Solution {
    int sum = 0;
    int[] nums;
    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        backtrack(0, 0);
        return sum;
    }
    private void backtrack(int start, int currentXor){
        sum += currentXor;
        for(int i = start; i < nums.length; i++){
            backtrack(i + 1, currentXor ^ nums[i]);
        }
    }
}