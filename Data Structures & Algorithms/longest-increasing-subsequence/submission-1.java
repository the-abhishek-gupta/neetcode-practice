class Solution {
    List<Integer> list = new ArrayList<>();
    public int lengthOfLIS(int[] nums) {
        for (int each : nums){
            if (list.isEmpty() || each > list.get(list.size()-1))
                list.add(each);
            else{
                list.set(findIndex(each), each);
            }
        }
        return list.size();
    }
    private int findIndex(int num){
        int start = 0;
        int end = list.size()-1;
        while (start <= end){
            int mid = start + (end-start)/2;
            int midEle = list.get(mid);
            if (midEle < num)
                start = mid+1;
            else
                end = mid-1;
        }
        return start;
    }
}
