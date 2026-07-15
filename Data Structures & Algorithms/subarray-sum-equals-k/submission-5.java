class Solution {
    public int subarraySum(int[] nums, int k) {
        // int count = 0;
        // for(int i = 0; i < nums.length; i++){
        //     int prefixSum = 0;
        //     for(int j = i; j < nums.length; j++){
        //         prefixSum += nums[j];
        //         if(prefixSum == k) count++;
        //     }
        // }
        // return count;
        // Optimal solution
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0, count = 0;
        for(int num : nums){
            prefixSum += num;
            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}