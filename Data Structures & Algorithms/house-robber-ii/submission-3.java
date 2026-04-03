class Solution {
    int nums[];
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        this.nums = nums;
        int robFirst = rob(0, n-2);
        int robLast = rob(1, n-1);
        return Math.max(robFirst, robLast);
    }
    private int rob(int start, int end){
        if (start > end)
            return 0;
        if (start == end)
            return nums[start];

        int n = end - start + 1;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);
        for (int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], nums[i+start] + dp[i-2]);
        }
        return dp[n-1];
    }
}
