class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        Stack<int[]> stack = new Stack<>();
        for (int[] each : intervals){
            if (stack.isEmpty())
                stack.push(each);
            else{
                int[] top = stack.peek();
                if (top[1] >= each[0]){
                    stack.pop();
                    each[0] = Math.min(each[0], top[0]);
                    each[1] = Math.max(each[1], top[1]);
                }
                stack.push(each);
            }
        }
        int[][] ans = new int[stack.size()][2];
        for (int i = stack.size()-1; i >= 0; i--){
            int[] each = stack.pop();
            ans[i][0] = each[0];
            ans[i][1] = each[1];
        }
        return ans;
    }
}
