class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int ct = 0;
        for (int each : nums){
            sum += each;
            if (map.containsKey(sum-k))
                ct += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ct;
    }
}