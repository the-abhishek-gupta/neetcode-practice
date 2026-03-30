class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String each : deadends)
            set.add(each);

        if (set.contains("0000")) return -1;
        int turns = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        set.add("0000");

        while (!queue.isEmpty()){
            for (int i = queue.size(); i > 0; i--){
                String lock = queue.poll();
                if (lock.equals(target))
                    return turns;
                for (String next : getNext(lock)){
                    if (!set.contains(next)){
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
    List<String> getNext(String s){
        List<String> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < 4; i++){
            char ch = arr[i];
            int c = ch - '0';
            arr[i] = (char) ('0' + (c + 1) % 10);
            list.add(new String(arr));

            arr[i] = (char) ('0' + (c + 9) % 10);
            list.add(new String(arr));

            arr[i] = ch;
        }
        return list;
    }
}