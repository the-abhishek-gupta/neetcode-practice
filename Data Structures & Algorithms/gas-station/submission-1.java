class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        int rem = 0;
        for (int i = 0; i < n; i++){
            rem += gas[i] - cost[i];
            totalGas+= gas[i];
            totalCost += cost[i];
            if (rem < 0){
                rem = 0;
                start = i+1;
            }
        }
        if (totalGas >= totalCost)
            return start;
        return -1;
    }
}
