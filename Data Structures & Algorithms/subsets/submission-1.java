class Solution {
    List<List<Integer>> ans;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.ans = new ArrayList<>();
        this.nums = nums;
        dfs(new ArrayList<>(), 0);
        return ans;
    }
    private void dfs(List<Integer> list, int index){
        if (index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(list, index+1);
        list.remove(list.size()-1);
        dfs(list, index+1);
    }
}
