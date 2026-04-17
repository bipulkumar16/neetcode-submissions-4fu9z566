class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new LinkedHashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int i = 0;
    for (int num : set) {
        nums[i++] = num;
    }
    return set.size();
        
    }
}