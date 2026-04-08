class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, int target, int start, List<Integer> path){
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0) return;
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, target - nums[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}
