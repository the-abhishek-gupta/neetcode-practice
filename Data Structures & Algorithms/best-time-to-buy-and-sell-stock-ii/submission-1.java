class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        int buy = prices[0];
        for (int sell : prices){
            if (sell > buy){
                total += sell-buy;
            }
            buy = sell;
        }
        return total;
    }
}