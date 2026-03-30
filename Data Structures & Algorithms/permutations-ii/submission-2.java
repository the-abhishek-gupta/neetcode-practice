class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, nums, 0);
        return ans;
    }
    void dfs(List<List<Integer>> ans, int[] nums, int index){
        if (index == nums.length){
            ans.add(getList(nums));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int j = index; j < nums.length; j++){
            if (set.contains(nums[j]))
                continue;
            set.add(nums[j]);
            swap(nums, index, j);
            dfs(ans, nums, index+1);
            swap(nums, j, index);
        }
    }
    List<Integer> getList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int each : nums)
            list.add(each);
        return list;
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}