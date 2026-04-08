class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        backtrack(0, new ArrayList<>());
        return result;
    }
    private void backtrack(int start, List<Integer> path){
        result.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backtrack(i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
