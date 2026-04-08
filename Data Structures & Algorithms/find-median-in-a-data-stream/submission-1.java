class MedianFinder {
    // we can also use two heap to find Median
    private PriorityQueue<Integer> maxHeap; // left maxHeap
    private PriorityQueue<Integer> minHeap;  // right minHeap

    public MedianFinder(){
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num){
        maxHeap.offer(num);

        minHeap.offer(maxHeap.poll());

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
    // Using Brute force
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
    //         return list.get(n/2);
    //     } else {
    //         return (list.get(n/2 - 1) + list.get(n/2)) / 2.0;
    //     }
    // }
}
