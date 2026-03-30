class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] each : dp)
            Arrays.fill(each, -1);
        return check(dp, prices, 0, true);
    }
    private int check(int[][] dp, int[] prices, int index, boolean canBuy){
        if (index >= prices.length)
            return 0;
        if (canBuy){
            if (dp[index][0] == -1){
                int profitOnBuying = -prices[index]+ check(dp, prices, index+1, false);
                int profitOnNotBuying = check(dp, prices, index+1, true);
                dp[index][0] = Math.max(profitOnBuying, profitOnNotBuying);
            }
            return dp[index][0];
        }
        else{
            if (dp[index][1] == -1){
                int profitOnSelling = prices[index] + check(dp, prices, index+2, true);
                int profitOnNotSelling = check(dp, prices, index+1, false);
                dp[index][1] = Math.max(profitOnSelling, profitOnNotSelling);
            }
            return dp[index][1];
        }
    }
}
