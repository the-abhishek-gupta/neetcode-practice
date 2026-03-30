class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] < 0)
                nums[i] = 0;
        }
        for (int i = 0; i < n; i++){
            int each = Math.abs(nums[i]);
            if (each > 0 && each < n+1){
                if (nums[each-1] > 0)
                    nums[each-1] *= -1;
                else if (nums[each-1] == 0)
                    nums[each-1] = -1 * (n+1);
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] >=0)
                return i+1;
        }
        return n+1;
    }
}