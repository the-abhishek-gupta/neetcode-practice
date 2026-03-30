class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = max(piles);
        int minHour = Integer.MAX_VALUE;
        while (start <= end){
            int mid = start + (end-start)/2 ;
            long hours = calc(piles, mid);
            if (hours <= h)
                minHour = mid;
            if (hours > h)
                start = mid+1;
            else
                end = mid-1;
        }
        return minHour;
    }
    long calc(int[] piles, int val){
        long ct = 0;
        for (int each : piles){
            int x = each / val;
            if (each % val != 0)
                x++;
            ct += x;
        }
        return ct;
    }
    int max(int[] piles){
        int max = piles[0];
        for (int each : piles)
            max = Math.max(max, each);
        return max;
    }
}
