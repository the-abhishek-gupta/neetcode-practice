class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> list = new PriorityQueue<>((a,b)-> b[0]- a[0]);
        for (int i = 0; i < position.length; i++){
            list.offer(new int[]{position[i], speed[i]});
        }
        double maxTime = 0;
        int ct = 0;
        while (!list.isEmpty()){
            int[] car = list.poll();
            double timeTaken = (double)(target - car[0])/ car[1];
            if (timeTaken > maxTime){
                maxTime = timeTaken;
                ct++;
            }
        }
        return ct;
    }
}
