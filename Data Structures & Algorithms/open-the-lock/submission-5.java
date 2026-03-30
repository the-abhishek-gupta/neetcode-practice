class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String each : deadends)
            dead.add(each);
        if (dead.contains("0000")) return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        int ct = 0;
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int k = 0; k < n; k++){
                String lock = queue.poll();
                if (lock.equals(target))
                    return ct;
                for (int i = 0; i < 4; i++){
                    String up = getCopy(lock, i, 1);
                    String down = getCopy(lock, i, -1);
                    if (!dead.contains(up) && !visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    if (!dead.contains(down) && !visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            ct++;
        }
        return -1;
    }
    private String getCopy(String str, int pos, int add){
        char[] arr = str.toCharArray();
        int c = arr[pos] - '0';
        int next = (c+add + 10) % 10;
        arr[pos] = ((char)('0' + next));
        return new String(arr);
    }
}