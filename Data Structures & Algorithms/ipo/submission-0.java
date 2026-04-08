class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);

        // Put all projects into capital heap
        for(int i = 0; i < profits.length; i++){
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        for(int i = 0; i < k; i++){
            // Move affordable projects to profit heap
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w){
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }

            // No project available
            if(maxProfitHeap.isEmpty()) break;

            // Choose most profitable
            w += maxProfitHeap.poll();
        }
        return w;
    }
}