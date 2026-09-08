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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) return true;
        int[][] temp = new int[intervals.size()][2];
        int x = 0;
        for (Interval i : intervals){
            temp[x][0] = i.start;
            temp[x][1] = i.end;
            x++;
        }
        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));

        int[] prev = temp[0];
        for (int i = 1; i < temp.length; i++){
            if (prev[1] > temp[i][0]) return false;
            else{
                prev = new int[2];
                prev = temp[i];
            }
        }
        return true;
    }
}
