class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++){
            if (nums[i]>0)
                break;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int start = i+1;
            int end = n-1;
            while (start < end){
            int sum = nums[i] + nums[start]+ nums[end];
                if (sum > 0)
                    end--;
                else if (sum < 0)
                    start++;
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    ans.add(new ArrayList<>(list));
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    
                    end--;
                    start++;
                    
                }
                
            }
        }
        return ans;
    }
}
