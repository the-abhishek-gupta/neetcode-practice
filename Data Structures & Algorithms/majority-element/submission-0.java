class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int ct = 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == major)
                ct++;
            else{
                ct--;
                if (ct < 0){
                    major = nums[i];
                    ct = 1;
                }
            }
        }
        return major;
    }
}