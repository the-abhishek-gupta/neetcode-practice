class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int sell : prices){
            if (buy > sell)
                buy = sell;
            profit = Math.max(profit, sell - buy);
        }
        return profit;
    }
}
