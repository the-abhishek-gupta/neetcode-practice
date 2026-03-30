class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length-1;
        int max = 0;

        while (start < end){
            int area = (end - start) * Math.min(heights[start], heights[end]);
            max = Math.max(max, area);
            if (heights[start] < heights[end])
                start++;
            else
                end--;
        }
        return max;
    }
}
