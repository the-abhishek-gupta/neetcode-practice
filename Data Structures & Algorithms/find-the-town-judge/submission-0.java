class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] dp = new int[n][2];
        for (int[] each : trust){
            int from = each[0];
            int on = each[1];
            dp[from-1][0]++;
            dp[on-1][1]++;
        }
        for (int i = 0; i < n; i++){
            if (dp[i][0] == 0 && dp[i][1] == n-1)
                return i+1;
        }
        return -1;
    }
}