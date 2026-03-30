class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int each : nums)
            ans = ans^each;
        return ans;
    }
}
