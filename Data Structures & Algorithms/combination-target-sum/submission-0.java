class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans,new ArrayList<>(), nums, target, 0);
        return ans;
    }
    void dfs(List<List<Integer>> ans,List<Integer> holder, int[] nums, int target, int index){
        if (target < 0)
            return;
        if (target == 0){
            ans.add(new ArrayList<>(holder));
            return;
        }
        for (int i = index; i < nums.length; i++){
            int each = nums[i];
            holder.add(each);
            dfs(ans, holder, nums, target- each, i);
            holder.remove(holder.size()-1);
        }
    }
}
