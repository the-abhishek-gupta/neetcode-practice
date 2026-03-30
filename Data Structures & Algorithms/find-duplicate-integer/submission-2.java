class Solution {
    public int findDuplicate(int[] nums) {
        for (int each : nums){
            int index = Math.abs(each)-1;
            if (nums[index] < 0)
                return index+1;
            nums[index] *= -1;
        }
        return -1;
    }
}
