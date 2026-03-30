class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] ngl = new int[n];
        int[] ngr = new int[n];
        ngl[0] = height[0];
        ngr[n-1] = height[n-1];
        for (int i = 1; i < n; i++){
            ngl[i] = Math.max(ngl[i-1] , height[i]);
        }
        for (int i = n-2; i >= 0; i--)
            ngr[i] = Math.max(ngr[i+1], height[i]);
        int total = 0;
        for (int i = 0; i < n; i++){
            total += Math.min(ngr[i], ngl[i]) - height[i];
        }
        return total;
    }
}
