class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int num : map.keySet()){
            int count = map.get(num);
            if(buckets[count] == null){
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(num);
        }
        int[] result = new int[k];
        int idx = 0;
        for(int i = buckets.length - 1; i >= 0 && idx < k; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    result[idx++] = num;
                    if(idx == k) break;
                }
            }
        }
        return result;
    }
}
