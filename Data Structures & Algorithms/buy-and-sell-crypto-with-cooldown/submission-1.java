class Solution {
    int[] prices;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] each : dp)
            Arrays.fill(each, -1);

        return solve(0, false, dp);
    }
    int solve(int index, boolean canSell, int[][] dp){
        if (index >= prices.length)
            return 0;
        if (!canSell){
            if (dp[index][0] == -1){
                int profitOnBuying = -prices[index] +solve(index+1, true, dp);
                int profitOnNotBuying = solve(index+1, false, dp);
                dp[index][0] = Math.max(profitOnBuying, profitOnNotBuying);
            }
            return dp[index][0];
        }
        else{
            if (dp[index][1] == -1){
                int profitOnSelling = prices[index] + solve(index+2, false, dp);
                int profitOnNotSelling = solve(index+1, true, dp);
                dp[index][1] = Math.max(profitOnSelling, profitOnNotSelling);
            }
            return dp[index][1];
        }
    }
}
