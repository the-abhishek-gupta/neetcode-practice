class Solution {
    int[] arr;
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        this.arr = stoneValue;
        int n = stoneValue.length;
        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int result = dfs(0);
        if (result == 0)
            return "Tie";
        if (result < 0)
            return "Bob";
    
        return "Alice";
    }
    private int dfs(int index){

        if (index >= arr.length) return 0;
        if (dp[index] == Integer.MIN_VALUE){
            int sum = 0;
            int value = Integer.MIN_VALUE;
            for (int i = index; i < Math.min(arr.length, index+3); i++){
                sum += arr[i];
                value = Math.max(value, sum - dfs(i + 1));
            }
            dp[index] = value;
        }
        return dp[index];
    }
}