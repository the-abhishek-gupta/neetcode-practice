class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, nums, 0);
        return ans;
    }
    void dfs(List<List<Integer>> ans, int[] nums, int index){
        if (index == nums.length){
            List<Integer> list = new ArrayList<>();
            for (int each : nums)
                list.add(each);
            ans.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++){
            swap(nums, i, index);
            dfs(ans, nums, index+1);
            swap(nums, index, i);
        }
    }
    
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
