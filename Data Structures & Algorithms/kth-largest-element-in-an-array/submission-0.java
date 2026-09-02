class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int x : nums){
            maxPQ.offer(x);
        }
        int result = 0;
        for(int i = 0; i < k; i++){
            result = maxPQ.poll();
        }
        return result;
    }
}
