class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        maxHeap.addAll(map.keySet());
        StringBuilder result = new StringBuilder();
        while(maxHeap.size() > 1){
            char first = maxHeap.poll();
            char second = maxHeap.poll();
             result.append(first);
             result.append(second);

             map.put(first, map.get(first) - 1);
             map.put(second, map.get(second) - 1);

             if(map.get(first) > 0) maxHeap.offer(first);
             if(map.get(second) > 0) maxHeap.offer(second);
        }
        if(!maxHeap.isEmpty()){
            char last = maxHeap.poll();
            if(map.get(last) > 1) return "";
            result.append(last);
        }
        return result.toString();
    }
}