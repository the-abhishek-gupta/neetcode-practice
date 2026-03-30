class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++){
            int maxJump = i + nums[i];
            for (int j = i+1; j <= maxJump && j < n; j++){
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        return dp[n-1];
    }
}
