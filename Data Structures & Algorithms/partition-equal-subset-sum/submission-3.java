class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int each : nums)
            sum += each;
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for (int num : nums){
            for (int i = sum ; i >= num; i--){
                if (dp[i-num]){
                    dp[i] = true;
                }
            }
        }

        return dp[sum];
    }
    
}
