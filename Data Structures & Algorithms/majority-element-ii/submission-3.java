class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int first = -1, second = -1, ct1 = 0, ct2 = 0;
        int n = nums.length;

        for (int each : nums){
            if (each == first)
                ct1++;
            else if (each == second)
                ct2++;
            else if (ct1 == 0){
                first = each;
                ct1 = 1;
            }
            else if (ct2 == 0){
                second = each;
                ct2 = 1;
            }
            else{
                ct1--;
                ct2--;
            }
        }
        int c1 = 0, c2 = 0;
        for (int each : nums){
            if (each == first)
                c1++;
            else if (each == second)
                c2++;
        }
        List<Integer> ans = new ArrayList<>();

        if (c1 > n/3)
            ans.add(first);
        if (c2 > n/3)
            ans.add(second);
        return ans;

    }
}