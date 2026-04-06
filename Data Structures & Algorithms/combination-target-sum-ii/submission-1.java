class Solution {
    List<List<Integer>> ans;
    int[] arr;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.ans = new ArrayList<>();
        this.arr = candidates;
        backtrack(new ArrayList<>(),0, target);
        return ans;
    }
    private void backtrack(List<Integer> list, int index, int target){
        if (target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = index; i < arr.length; i++){
            if (i > index && arr[i] == arr[i-1])
                continue;
            if (arr[i] > target){
                return;
            }
            list.add(arr[i]);
            backtrack(list, i+1, target - arr[i]);
            list.remove(list.size()-1);
        }
    }
}
