class Solution {
    public int maxProduct(int[] nums) {
        int currentMin = nums[0];
        int currentMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++){
            int no = nums[i];
            int noXMin = no * currentMin;
            int noXMax = no * currentMax;

            currentMin = Math.min(no, Math.min(noXMax, noXMin));
            currentMax = Math.max(no, Math.max(noXMax, noXMin));

            globalMax = Math.max(globalMax, Math.max(currentMin, currentMax));
        }
        return globalMax;
    }
}
