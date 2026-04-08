class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    private void backtrack(List<Integer> perm, int[] nums, boolean[] path){
        if(perm.size() == nums.length){
            result.add(new ArrayList<>(perm));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!path[i]){
                perm.add(nums[i]);
                path[i] = true;
                backtrack(perm, nums, path);
                perm.remove(perm.size() - 1);
                path[i] = false;
            }
            
        }
    }
}
