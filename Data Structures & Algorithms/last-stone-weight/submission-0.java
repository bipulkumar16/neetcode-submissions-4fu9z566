class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size() > 1){
            int firstMax = maxHeap.poll();
            int secondMax = maxHeap.poll();

            if(firstMax != secondMax){
                maxHeap.add(firstMax - secondMax);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
