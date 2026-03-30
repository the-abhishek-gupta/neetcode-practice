class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int each : nums){
            if (set.contains(each))
                return true;
            set.add(each);
        }
        return false;
    }
}