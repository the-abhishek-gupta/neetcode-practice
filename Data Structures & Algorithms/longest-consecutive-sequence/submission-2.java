class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int each : nums){
            set.add(each);
        }
        int max = 0;
        
        for (int each : set){
            if (!set.contains(each-1)){
                int len = 0;
                while (set.contains(each)){
                    each++;
                    len++;
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }

}
