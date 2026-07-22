class MedianFinder {

    PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    PriorityQueue<Integer> max = new PriorityQueue<Integer>((a,b)-> b-a);

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll()); 
        if(min.size() > max.size()){
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if(min.size()== max.size()){
            return (min.peek() + max.peek())/2.0;
        }

        return max.peek();
        
    }
}
