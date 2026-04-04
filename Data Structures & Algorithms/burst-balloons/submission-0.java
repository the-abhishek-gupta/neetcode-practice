class Solution {
    int[][] dp;
    int[] nums;
    public int maxCoins(int[] originalNums) {
        int n = originalNums.length;
        this.dp = new int[n+2][n+2];
        for (int[] each : dp)
            Arrays.fill(each, -1);
        nums = new int[n + 2];
        nums[0] = 1;
        nums[n + 1] = 1;
        for (int i = 0; i < n; i++) nums[i + 1] = originalNums[i];
                return dfs(1, n);
    }
    
    private int dfs(int left, int right){
        if (left > right)
            return 0;
        if (dp[left][right] == -1){
            int max = 0;
            for (int i = left; i <=right; i++){
                int gain = nums[left - 1] * nums[i] * nums[right + 1];
                int res = gain + dfs(left, i-1) + dfs(i+1, right);
                max = Math.max(max, res);
            }
            dp[left][right] = max;
        }
        return dp[left][right];
    }
}
