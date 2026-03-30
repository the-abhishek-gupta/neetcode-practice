class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] flag = new boolean[100001];
        for (int each : nums){
            if (each > 0)
                flag[each] = true;
        }
        for (int i = 1; i <= 100000; i++)
            if (!flag[i])
                return i;
        return -1;
    }
}