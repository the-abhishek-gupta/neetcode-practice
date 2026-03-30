class Solution {
    private Map<Integer, Integer> map;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        map = new HashMap<>();
        map.put(0, 1);
        return dfs(nums, target);
    }
    int dfs(int[] nums, int target){
        if (map.containsKey(target))
            return map.get(target);
        int ct = 0;
        for (int each : nums){
            if (each > target)
                break;
            ct += dfs(nums, target-each);
        }
        map.put(target, ct);
        return ct;
    }
    
}