class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        
        for (int i = 0; i < n; i++){
            int h = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= h)
                stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            if (stack.isEmpty() || h > heights[stack.peek()])
                stack.push(i);
            System.out.print(left[i]+" ");
        }
        System.out.println();
         stack = new Stack<>();
        int[] right = new int[n];
        
        for (int i = n-1; i >=0; i--){
            int h = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= h)
                stack.pop();
            right[i] = stack.isEmpty() ? n : stack.peek();
            if (stack.isEmpty() || h > heights[stack.peek()])
                stack.push(i);
            System.out.print(right[i]+" ");
        }
        int max = 0;
        for (int i = 0; i < n; i++){
            max = Math.max(max, heights[i] * (right[i]-left[i]-1));
        }
        return max;

    }
}
