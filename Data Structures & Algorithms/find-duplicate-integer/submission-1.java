class Solution {
    public int findDuplicate(int[] nums) {
        // Optimal Solution
        int slow = nums[0];
        int fast = nums[0];

        slow = nums[slow];
        fast = nums[nums[fast]];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
        // HashSet<Integer> seen = new HashSet<>();
        // for(int num : nums){
        //     if(seen.contains(num)){
        //         return num;
        //     }
        //     seen.add(num);
        // }
        // return -1;
    }
}
