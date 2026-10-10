class MedianFinder {
    // Heap properties
    private PriorityQueue<Integer> maxHeap; // left (max heap)
    private PriorityQueue<Integer> minHeap; // right (min heap)

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // max heap
        minHeap = new PriorityQueue<>(); // min heap
    }

    public void addNum(int num){
        // Step 1: Add to maxHeap
        maxHeap.offer(num);

        // Step 2: Ensure order property
        minHeap.offer(maxHeap.poll());

        // Step 3: Balance sizes
        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian(){
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
    //Brute Force
    // private List<Integer> list;

    // public MedianFinder() {
    //     list = new ArrayList<>();
    // }
    
    // public void addNum(int num) {
    //     list.add(num);
    // }
    
    // public double findMedian() {
    //     Collections.sort(list);
    //     int n = list.size();
    //     if(n % 2 == 1){
    //         return list.get(n / 2);
    //     } else {
    //         return (list.get(n / 2 -1) + list.get(n / 2)) / 2.0;
    //     }
    // }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
