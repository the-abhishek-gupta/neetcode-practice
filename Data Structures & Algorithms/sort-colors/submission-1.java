class Solution {
    public void sortColors(int[] nums) {
        int[] ct = new int[3];
        for (int each : nums){
            ct[each]++;
        }
        
        int index = 0;
        for (int i = 0; i < ct[0]; i++)
            nums[index++] = 0;
        for (int i = 0; i < ct[1]; i++)
            nums[index++] = 1;
        for (int i = 0; i < ct[2]; i++)
            nums[index++] = 2;
    }
}