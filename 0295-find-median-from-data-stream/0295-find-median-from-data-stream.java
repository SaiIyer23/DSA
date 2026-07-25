class MedianFinder {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    public MedianFinder() {
        low=new PriorityQueue<>();
        high=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        high.offer(num);
        low.offer(high.poll());
        if(low.size()>high.size()){
            high.offer(low.poll());
        }
    }
    
    public double findMedian() {
        if(low.size()==high.size()){
            return (low.peek()+high.peek())/2.0;
        }
        return high.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */