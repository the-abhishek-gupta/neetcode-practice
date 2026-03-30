class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int start = i+1;
            int end = n-1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > 0)
                    end--;
                else if (sum < 0)
                    start++;
                else{
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start-1])
                        start++; 
                }
            }
        }
        return ans;
    }
}
