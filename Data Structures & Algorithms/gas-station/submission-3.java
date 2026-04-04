class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentStart = 0;
        int currentGas = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0){
                currentGas = 0;
                currentStart = i+1;
            }
        }
        return (total >= 0) ? currentStart : -1;
    }
}
