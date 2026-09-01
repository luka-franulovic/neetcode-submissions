class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int x : stones){
            maxPQ.add(x);
        }
        while (maxPQ.size() > 1){
            int stone1 = maxPQ.poll();
            int stone2 = maxPQ.poll();
            
            if (stone1 != stone2){
                maxPQ.add(Math.abs(stone1 - stone2));
            }
        }
        if (maxPQ.size() == 0) return 0;
        return maxPQ.peek();
    }
}
