class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
    void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, int index){
        if (index == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        dfs(ans, temp, nums, index+1);
        temp.remove(temp.size()-1);
        while (index < nums.length - 1 && nums[index] == nums[index+1])
            index++;
        dfs(ans, temp, nums, index+1);
    }
}
