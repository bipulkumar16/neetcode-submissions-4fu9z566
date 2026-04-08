class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(int num : map.keySet()){
            if(map.get(num) > nums.length/3){
                list.add(num);
            }
        }
        return list;
    }
}