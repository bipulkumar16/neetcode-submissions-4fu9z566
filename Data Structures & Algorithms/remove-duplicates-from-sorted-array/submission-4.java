class Solution {
    public int removeDuplicates(int[] nums) {
        // HashSet<Integer> set = new LinkedHashSet<>();
        // for(int num : nums){
        //     set.add(num);
        // }
        // int i = 0;
        // for(int num : set){
        //     nums[i++] = num;
        // }
        // return set.size();
        int i = 1;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[i - 1]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}