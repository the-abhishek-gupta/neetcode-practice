class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length < 2)
            return nums;
        int mid = nums.length/2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }
    private int[] merge(int[] a, int[] b){
        int ai = 0, bi = 0;
        int an = a.length;
        int bn = b.length;
        int[] ans = new int[an+bn];
        int i = 0;
        while(ai < an && bi < bn){
            if (a[ai] < b[bi])
                ans[i++] = a[ai++];
            else 
                ans[i++] = b[bi++]; 
        }
        while(ai < an)
            ans[i++] = a[ai++];
        
        while (bi < bn)
            ans[i++] = b[bi++]; 
        
        return ans;
            
    }
}