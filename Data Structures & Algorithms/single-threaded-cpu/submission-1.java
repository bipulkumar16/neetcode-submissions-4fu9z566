class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] newTasks = new int[n][3];
        for(int i = 0; i < n; i++){
            newTasks[i][0] = tasks[i][0]; // enqueue
            newTasks[i][1] = tasks[i][1]; // process
            newTasks[i][2] = i; // index
        }
        Arrays.sort(newTasks, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? 
        Integer.compare(a[2], b[2]) : Integer.compare(a[1], b[1]));

        long time = 0;
        int i = 0;
        int[] result = new int[n];
        int idx = 0;

        while(i < n || !minHeap.isEmpty()){
            if(minHeap.isEmpty() && time < newTasks[i][0]){
                time = newTasks[i][0];
            }
            while(i < n && newTasks[i][0] <= time){
                minHeap.offer(newTasks[i]);
                i++;
            }
            int[] curr = minHeap.poll();
            time += curr[1];
            result[idx++] = curr[2];
        }
        return result;
    }
}