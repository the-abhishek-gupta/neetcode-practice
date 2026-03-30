class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ref = new ArrayList<>();
        for (int i = 1; i <=n; i++)
            ref.add(i);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), ref, k, 0);
        return ans;
    }
    void dfs(List<List<Integer>> ans, List<Integer> temp, List<Integer> ref, int size, int index){
        if (index > ref.size())
            return;
        if (temp.size() == size){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < ref.size(); i++){
            temp.add(ref.get(i));
            dfs(ans, temp, ref, size, i+1);
            temp.remove(temp.size()-1);
        }
    }
}