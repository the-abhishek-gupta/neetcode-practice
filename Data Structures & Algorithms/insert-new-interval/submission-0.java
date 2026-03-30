class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        list.add(newInterval);
        for (int[] each : intervals)
            list.add(each);
        Collections.sort(list, (a,b)-> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        for (int[] each : list){
            if (stack.isEmpty())
                stack.push(each);
            else{
                int[] top = stack.peek();
                if (top[1] < each[0]){
                    stack.push(each);
                }
                else{
                    stack.pop();
                    each[0] = Math.min(top[0], each[0]);
                    each[1] = Math.max(top[1], each[1]);
                    stack.push(each);
                }
            }
        }
        int[][] ans = new int[stack.size()][2];
        for (int i = stack.size()-1; i >= 0; i--){
            int[] each = stack.pop();
            ans[i][0] = each[0];
            ans[i][1] = each[1];
        }
            // System.out.println(each[0]+" "+each[1]);
        return ans;
    }
}
