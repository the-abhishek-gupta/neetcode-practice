class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] each : intervals)
            list.add(each);
        list.add(newInterval);
        list.sort((a,b)-> a[0]-b[0]);
        Stack<int []> stack = new Stack<>();
        for (int[] each : list){
        
            if (!stack.isEmpty() && stack.peek()[1] >= each[0]){
                int[] top = stack.pop();
                each[0] = Math.min(each[0], top[0]);
                each[1] = Math.max(each[1], top[1]);
            }
            stack.push(each);
            
            System.out.println(each[0]+" "+each[1]);
        }
        int n = stack.size();
        int[][] ans = new int[n][2];
        for (int i = n-1; i >=0; i--){
            int[] top = stack.pop();
            ans[i][0]= top[0];
            ans[i][1] = top[1];
        }

        return ans;
    }
}
