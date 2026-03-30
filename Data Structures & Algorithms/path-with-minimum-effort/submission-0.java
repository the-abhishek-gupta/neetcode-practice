class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] visited = new int[m][n];
        for (int[] each : visited)
            Arrays.fill(each, Integer.MAX_VALUE);

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        visited[0][0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        queue.offer(new int[]{0,0,0});
        
        while (!queue.isEmpty()){
            int[] currentNode = queue.poll();
            int x = currentNode[0];
            int y = currentNode[1];
            int diff = currentNode[2];
            if (x == m-1 && y == n-1)
                return diff;
            if (diff > visited[x][y])
                continue;
            for (int[] d : directions){
                int dx = d[0];
                int dy = d[1];
                int X = x+dx;
                int Y = y+ dy;
                if (X >=0 && X < m && Y >= 0 && Y < n){
                    int newDiff = Math.max(diff, Math.abs(heights[x][y] - heights[X][Y]));
                    if (newDiff < visited[X][Y]){
                        visited[X][Y] = newDiff;
                        queue.offer(new int[]{X,Y, newDiff});
                    }
                }
            }
        }
        return 0;
    }
}