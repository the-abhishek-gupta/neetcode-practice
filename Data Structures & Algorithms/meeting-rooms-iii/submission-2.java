class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] ct = new int[n];
        Arrays.fill(ct, 0);
        PriorityQueue<Room> used = new PriorityQueue<>((a,b) -> (a.end == b.end)? a.id - b.id : a.end - b.end); 
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        PriorityQueue<Room> available = new PriorityQueue<>((a,b) -> a.id - b.id); 
        for (int i = 0; i < n; i++)
            available.offer(new Room(i, 0));
        for (int[] each : meetings){
            while (!used.isEmpty() && used.peek().end <= each[0]){
                available.offer(used.poll());
            }
            Room r;
            if (!available.isEmpty()) {
                r = available.poll();
                r.end = each[1];
            } else {
                r = used.poll();
                r.end += each[1] - each[0];
            }
            ct[r.id]++;
            used.offer(r);
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