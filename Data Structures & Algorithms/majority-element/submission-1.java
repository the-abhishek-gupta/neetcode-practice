class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int ct = 0;
        for (int each : nums){
            if (each == major)
                ct++;
            else{
                ct--;
                if (ct < 0){
                    major = each;
                    ct = 0;
                }
            }
        }
        return major;
    }
}