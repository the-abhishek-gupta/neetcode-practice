class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 0, candidates, target);
        return ans;
    }
    void dfs(List<List<Integer>> ans, List<Integer> holder, int index, int[] nums, int target){
        
        if (target == 0){
            ans.add(new ArrayList<>(holder));
            return;
        }
        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i-1])
                continue;
            if (target - nums[i] < 0)
                return;
            holder.add(nums[i]);
            dfs(ans, holder, i+1, nums, target - nums[i]);
            holder.remove(holder.size()-1);
        }
    }
}
