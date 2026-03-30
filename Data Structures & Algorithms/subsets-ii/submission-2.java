class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
    void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, int index){
        ans.add(new ArrayList<>(temp));
        for (int j = index; j < nums.length; j++){
            if (j > index && nums[j] == nums[j-1])
                continue;
            temp.add(nums[j]);
            dfs(ans, temp, nums, j+1);
            temp.remove(temp.size()-1);
        }
        
    }
}
