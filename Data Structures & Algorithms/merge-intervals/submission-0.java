class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<int[]>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] previous = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            if (previous[1] < intervals[i][0]){
                result.add(previous);
                previous = new int[2];
                previous[0] = intervals[i][0];
                previous[1] = intervals[i][1];
            }
            else{
                previous[0] = Math.min(previous[0], intervals[i][0]);
                previous[1] = Math.max(previous[1], intervals[i][1]);
            }
        }
        result.add(previous);
        return result.toArray(new int[result.size()][]);
    }
}
