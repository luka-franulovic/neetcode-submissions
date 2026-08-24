class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = Integer.MIN_VALUE;
        for (int x : piles){
            if (x > maxValue) maxValue = x;
        }
        int bestK = maxValue;
        int lo = 1;
        int hi = maxValue;
        while (lo <= hi){
            long numberOfHours = 0;
            int mid = lo + (hi - lo) / 2;
            for (int x : piles){
                numberOfHours += (x + mid - 1L) / mid;
            }
            if (numberOfHours <= h){
                bestK = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return bestK;
    }
}