class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }
    private void addToList(int[] arr){
        List<Integer> t = new ArrayList<>();
        for (int each : arr)
            t.add(each);
        ans.add(t);
    }
    private void backtrack(int[] nums, int index){
        if (index == nums.length){
            addToList(nums);
            return;
        }
        for (int i = index; i < nums.length; i++){
            swap(nums, i, index);
            backtrack(nums, index+1);
            swap(nums, index, i);
        }
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
