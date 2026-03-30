class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = getMax(weights);
        int end = getSum(weights);
        int ans = end;
        while (start <= end){
            int mid = (start+end)/2;
            int reqDays = calc(weights, mid);        
            System.out.println("start "+ start+" end "+end);
            System.out.println("mid "+mid+" reqDays "+reqDays+" ans "+ans);
            if (reqDays <= days){
                ans = Math.min(ans,mid);
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return ans;
    }
    int calc(int[] weights, int limit){
        int ct = 0;
        int sum = 0;
        for (int each : weights){
            sum += each;
            if (sum > limit){
                ct++;
                sum = each;
            }
        }
        if (sum > 0)
            ct++;
        return ct;
    }
    int getMax(int[] weights){
        int max = weights[0];
        for (int i = 0; i < weights.length; i++)
            max = Math.max(max, weights[i]);
        return max;
    }
    int getSum(int[] weights){
        int sum = 0;
        for (int each : weights)
            sum += each;
        return sum;
    }
}