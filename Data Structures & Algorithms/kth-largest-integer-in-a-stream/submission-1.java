class KthLargest {

    private PriorityQueue<Integer> minPQ;
    private int k;

    public KthLargest(int k, int[] nums) {
        minPQ = new PriorityQueue<Integer>();
        this.k = k;
        for(int x : nums){
            add(x);
        }
    }
    
    public int add(int val) {
        if (minPQ.size() < k) {
            minPQ.offer(val);
        } 
        else if (val > minPQ.peek()) {
            minPQ.poll();
            minPQ.offer(val);
        }
        return minPQ.peek();
    }
}
