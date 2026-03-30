class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int each : nums){
            insert(list, each);
        }
        return list.size();
    }
    void insert(List<Integer> list, int num){
        if (list.isEmpty() || num > list.get(list.size()-1))
            list.add(num);
        else{
            for (int i = 0; i < list.size(); i++){
                if (list.get(i) >= num){
                    list.set(i, num);
                    return;
                }
            }
        }
    }
}
