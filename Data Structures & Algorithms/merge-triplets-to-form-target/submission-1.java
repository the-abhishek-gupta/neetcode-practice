class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int ct = 0;
        for (int[] each : triplets){
            if (each[0] > target[0] || each[1] > target[1] || each[2] > target[2])
                continue;
            for (int i = 0; i < target.length; i++)
                if (each[i]== target[i])
                    ct++;
        }
        return ct >= target.length;
    }
}
