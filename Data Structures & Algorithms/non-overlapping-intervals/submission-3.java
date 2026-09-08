class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int removes = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            if (prev[1] > intervals[i][0]){
                removes++;
                if (prev[1] >= intervals[i][1]){
                    prev = new int[2];
                    prev = intervals[i];
                }
            }
            else{
                prev = new int[2];
                prev = intervals[i];
            }
        }
        return removes;
    }
}
