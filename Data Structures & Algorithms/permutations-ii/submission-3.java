class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    private void backtrack(List<Integer> prem, int[] nums, boolean[] used){
        if(prem.size() == nums.length){
            result.add(new ArrayList<>(prem));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if(!used[i]){
               prem.add(nums[i]);
               used[i] = true;
               backtrack(prem, nums, used);
               prem.remove(prem.size() - 1);
               used[i] = false;
            }
        }
    }
}