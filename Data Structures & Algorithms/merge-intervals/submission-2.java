class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        Stack<int[]> stack = new Stack<>();
        for (int[] each : intervals){
            if (stack.isEmpty())
                stack.push(each);
            else{
                if (stack.peek()[1] >= each[0]){
                    int[] top = stack.pop();
                    each[0] = Math.min(top[0], each[0]);
                    each[1] = Math.max(top[1], each[1]);
                }
                stack.push(each);
            }
            // System.out.println(stack.peek()[0]+" "+stack.peek());
        }
        int n = stack.size();
        int[][] ans = new int[n][2];
        for (int i = n-1; i >=0; i--){
            int[] top = stack.pop();
            ans[i][0] = top[0];
            ans[i][1] = top[1];
        }
        return ans;
    }
}
