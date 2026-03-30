class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        return dfs(ans, nums, 0);
    }
    int dfs(int[] ans, int[] nums, int index){
        if (index >= nums.length)
            return 0;
        if (ans[index] == -1){
            ans[index] = Math.max(nums[index]+ dfs(ans, nums, index+2), dfs(ans, nums, index+1));
        }
        return ans[index];
    }
}
