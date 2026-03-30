class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        Stack<int[]> stack = new Stack<>();
        for (int[] each : intervals){
            if (stack.isEmpty())
                stack.push(each);
            else{
                int[] top = stack.peek();
                if (top[1] > each[0]){
                    stack.pop();
                    each[0] = Math.min(each[0], top[0]);
                    each[1] = Math.min(each[1], top[1]);
                }
                stack.push(each);
            }
        }
        System.out.println(stack.size());
        return intervals.length - stack.size();
    }
}
