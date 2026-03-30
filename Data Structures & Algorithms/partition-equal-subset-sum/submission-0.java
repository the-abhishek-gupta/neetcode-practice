class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int each : nums)
            sum += each;
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        return dfs(nums, sum, 0);
    }
    boolean dfs(int[] nums, int target, int index){
        if (index == nums.length)
            return target == 0;
        if (target < 0)
            return false;
        return dfs(nums, target, index+1) || dfs(nums, target - nums[index], index+1);
    }
}
