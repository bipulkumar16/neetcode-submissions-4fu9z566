class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for(char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.values());

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll() - 1;
                if(count > 0){
                    queue.offer(new int[]{count, time + n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxHeap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
    