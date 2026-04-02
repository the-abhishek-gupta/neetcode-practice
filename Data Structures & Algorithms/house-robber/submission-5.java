class Solution {
    int[] dp;
    int[] nums;
    public int rob(int[] nums) {
        int n = nums.length;
        this.dp = new int[n];
        this.nums = nums;
        Arrays.fill(dp, -1);
        return find(0);
    }
    private int find(int index){
        if (index >= nums.length)
            return 0;
        if (dp[index] == -1){
            int rob = nums[index] + find(index+2);
            int notRob = find(index+1);
            dp[index] = Math.max(rob, notRob);
        }
        return dp[index];

    }
}
