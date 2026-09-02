class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (char c : tasks){
            if (!map.containsKey(c)){
                map.put(c, 1);
            }
            else{
                map.put(c, map.get(c) + 1);
            }
        }

        for (char key : map.keySet()){
            maxPQ.offer(map.get(key));
        }
        Queue<Integer> buffer = new LinkedList<Integer>();
        int time = 0;
        while (!maxPQ.isEmpty() || !buffer.isEmpty()){
            if(!buffer.isEmpty() && buffer.peek() <= time){
                buffer.remove();
                maxPQ.offer(buffer.remove());
            }
            if (!maxPQ.isEmpty()){
                int current = maxPQ.poll();
                current--;
                if (current > 0){
                    buffer.offer(time + n + 1);
                    buffer.offer(current);
                }
            }
            time++;
        }
        return time;
    }
}
