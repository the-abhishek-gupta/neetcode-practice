class Solution {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for (int each : nums){
            arr[each]++;
        }
        int index = 0;
        int p = 0;
        for (int each : arr){
            while (each-- > 0)
                nums[index++] = p;
            p++;
        }

    }
}