class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b)-> b[2]-a[2]);

        int[] line = new int[trips[0][2] + 1];
        for (int[] each : trips){
            int n = each[0];
            int start = each[1];
            int end = each[2];
            line[start] += n;
            line[end] -= n;
        }
        for (int i = 1 ; i < line.length; i++){
            line[i] += line[i-1];
            if (line[i] > capacity)
                return false;
        }
        return true;
    }
}