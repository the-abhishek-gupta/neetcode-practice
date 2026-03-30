class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] ct = new int[n];
        Arrays.fill(ct, 0);
        PriorityQueue<Room> pq = new PriorityQueue<>((a,b) -> (a.end == b.end)? a.id - b.id : a.end - b.end); 
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        PriorityQueue<Room> temp = new PriorityQueue<>((a,b) -> a.id - b.id); 
        for (int i = 0; i < n; i++)
            temp.offer(new Room(i, 0));
        for (int[] each : meetings){
            while (!pq.isEmpty() && pq.peek().end <= each[0]){
                temp.offer( pq.poll());
            }
            Room r;
            if (!temp.isEmpty()) {
                r = temp.poll();
                r.end = each[1];
            } else {
                r = pq.poll();
                r.end += each[1] - each[0];
            }
            ct[r.id]++;
            pq.offer(r);
        }
        int max = 0;
        for (int i = 1; i < n; i++){
            if (ct[i] > ct[max])
                max = i;
        }
        return max;
    }
}
class Room{
    int id, end;
    Room(int i, int e){
        id = i;
        end = e;
    }
}