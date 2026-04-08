class Solution {
    public int majorityElement(int[] nums) {
        //Using HashMap
        // Map<Integer, Integer> map = new HashMap<>();
        // int n = nums.length - 1;

        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        //     if(map.get(num) > n/2){
        //     return num;
        //     }
        // }
        // return -1;
        //Optimal Solution
        int count = 0, candidate = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate)? 1 : -1;
        }
        return candidate;
    }
}