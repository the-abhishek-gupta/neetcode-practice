class Solution {
    public int maxProfit(int[] prices) {
        return dfs(0, false, prices);
    }
    int dfs(int index, boolean canSell, int[] prices){
        if (index >= prices.length)
            return 0;
        
        int coolDown = dfs(index+1, canSell, prices);
        int nextProfit = 
         (canSell)?
             prices[index] + dfs(index+2, !canSell, prices)
        :
             -prices[index] + dfs(index+1, true, prices);
            return Math.max(coolDown, nextProfit);
    }
}
