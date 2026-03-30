class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int current = 0;
        for (int each : nums){
            current+= each;
            maxSum = Math.max(maxSum, current);
            if (current < 0)
                current = 0;
        }
        return maxSum;
    }
}
