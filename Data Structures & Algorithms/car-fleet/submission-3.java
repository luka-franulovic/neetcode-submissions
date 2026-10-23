class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] arr = new double[position.length][2];
        for (int i = 0; i < position.length; i++)
        {
            arr[i][0] = position[i];
            arr[i][1] = (double)(target - position[i])/(double)speed[i];
        }
        Arrays.sort(arr, (a, b) -> Double.compare(b[0], a[0]));
        int fleets = 0;
        double maxTime = 0;
        for (int i = 0; i < position.length; i++)
        {
            if (arr[i][1] > maxTime){
                fleets++;
                maxTime = arr[i][1];
            }
        }
        return fleets;
    }
}
