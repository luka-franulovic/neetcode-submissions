/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) return 0;
        int[][] temp = new int[intervals.size()][2];
        int x = 0;
        for (Interval i : intervals){
            temp[x][0] = i.start;
            temp[x][1] = i.end;
            x++;
        }

        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));

        int prevEnd = temp[0][1];
        PriorityQueue<Integer> maxPq = new PriorityQueue<Integer>();
        maxPq.offer(prevEnd);
        for (int i = 1; i < temp.length; i++){
            int currentStart = temp[i][0];
            if (!maxPq.isEmpty()){
                prevEnd = maxPq.poll();
                if (prevEnd > currentStart){
                    maxPq.offer(prevEnd);
                }
            }
            maxPq.offer(temp[i][1]);
        }
        
        return maxPq.size();
    }
}
