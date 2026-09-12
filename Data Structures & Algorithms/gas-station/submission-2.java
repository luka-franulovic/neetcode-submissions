class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++){
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumCost > sumGas) return -1;

        int start = 0;
        int tank = 0;

        for (int i = 0; i < gas.length - 1; i++){
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i+1;
            }
        }

        return start;
    }
}
