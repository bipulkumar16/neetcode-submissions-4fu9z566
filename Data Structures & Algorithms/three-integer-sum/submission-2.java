class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                } else if(sum < 0){
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
            }
        }
        return result;
        // Brute force
        // Set<List<Integer>> result = new HashSet<>();
        // int n = nums.length;
        // Arrays.sort(nums);
        // for(int i = 0; i < n - 2; i++){
        //     for(int j = i + 1; j < n - 1; j++){
        //         for(int k = j + 1; k < n; k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 result.add(Arrays.asList(nums[i], nums[j], nums[k]));
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(result);
    }
}
