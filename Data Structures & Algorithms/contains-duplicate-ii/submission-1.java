class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int each = nums[i];
            if (map.containsKey(each) && i - map.get(each) <= k)
                return true;
            map.put(each, i);
        }
        return false;
    }
}