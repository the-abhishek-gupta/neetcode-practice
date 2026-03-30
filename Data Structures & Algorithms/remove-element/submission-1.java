class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int each : nums){
            if (each != val)
                nums[index++] = each;
        }
        return index;
    }
}