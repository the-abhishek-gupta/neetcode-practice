class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        Arrays.sort(nums);
        dfs(new ArrayList<>(), target, 0);
        return ans;
    }
    private void dfs(List<Integer> list, int target, int index){
        if (target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++){
            int each = nums[i];
            if (each > target)
                return;
            list.add(each);
            dfs(list, target - each, i);
            list.remove(list.size()-1);
        }
    }
}
