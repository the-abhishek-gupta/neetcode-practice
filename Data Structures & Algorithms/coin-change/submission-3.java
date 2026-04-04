class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount+1];
        Arrays.fill(ans, amount+1);
        ans[0] = 0;
        
        for (int i = 1; i <= amount; i++){
            for (int each : coins){
                if ( i >= each)
                    ans[i] = Math.min(ans[i], ans[i-each] + 1);
            }
        }
        return ans[amount] > amount ? -1 : ans[amount];
    }
}
