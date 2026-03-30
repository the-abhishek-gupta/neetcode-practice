class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n-2; i++){
            for (int j = i+1; j < n - 1; j++){
                int sum = nums[i] + nums[j];
                sum *= -1;
                for (int k = n-1; k > j; k--)
                    if (nums[k] == sum){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        ans.add(list);
                    }
            }
        }
        return new ArrayList<>(ans);
    }
}
