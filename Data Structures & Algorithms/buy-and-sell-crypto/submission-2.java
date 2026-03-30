class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++){
            int sell = prices[i];
            if (sell < buy)
                buy = sell;
            else
                max = Math.max(max, sell - buy);
        }
        return max;
    }
}
