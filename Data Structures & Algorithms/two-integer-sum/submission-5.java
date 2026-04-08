class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int common = target - nums[i];
            if(map.containsKey(common)){
                return new int[]{map.get(common), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
