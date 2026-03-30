class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = getMax(piles);
        int ans = end;
        while (start <= end){
            int mid = start + (end-start)/2;
            int timeToFinish = eat(piles, mid);
            if (timeToFinish <= h){
                ans = mid;
                end = mid-1;
            }
            else
                start = mid + 1;
        }
        return ans;
    }
    private int eat(int[] arr, int rate){
        int ct = 0 ;
        for (int each : arr){
            ct += each /rate;
            if (each % rate != 0)
                ct+=1;
        }
        return ct;
    }
    private int getMax(int[] arr){
        int x = arr[0];
        for (int each : arr)
            x = Math.max(x, each);
        return x;
    }
}
