class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> countedSet = new HashSet<>();
        for (int x : nums)
            set.add(x);
        for (int each : set){
            int right = 0, left = 0;
            int n = each, m = each;
            if (countedSet.contains(each))
                continue;
            while(set.contains(m++)){
                countedSet.add(m);
                right++;
            }
            while (set.contains(--n)){
                countedSet.add(n);
                left++;
            }
            // System.out.println(each+" "+n+" "+m);
            max = Math.max(max, left+right);
        }
        return max;
    }
}
