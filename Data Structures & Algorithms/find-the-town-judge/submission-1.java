class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inde = new int[n+1];
        int[] out = new int[n+1];
        for (int[] each : trust){
            out[each[0]]++;
            inde[each[1]]++;
        }
        for (int i = 1; i <= n; i++){
            if (inde[i] == n-1 && out[i] == 0)
                return i;
        }
        return -1;
    }
}