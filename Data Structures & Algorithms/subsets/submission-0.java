class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 0, nums);
        return ans;
    }
    void dfs(List<List<Integer>> ans, List<Integer> holder, int index, int[] nums){
        if (index >= nums.length){
            ans.add(new ArrayList<>(holder));
            return;
        }
        holder.add(nums[index]);
        dfs(ans, holder, index+1, nums);
        holder.remove(holder.size()-1);
        dfs(ans, holder, index+1, nums);
    }
}
