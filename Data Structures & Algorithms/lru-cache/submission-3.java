class LRUCache {

    Map<Integer, Integer> map;
    int cap;
    Queue<Integer> queue;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
        this.queue = new LinkedList<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            moveKeyToLast(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.put(key, value);
            moveKeyToLast(key);
        }
        else{
            if (queue.size() >= cap)
                map.remove(queue.poll());
            
            map.put(key, value);
            queue.offer(key);
        }
        
    }
    private void moveKeyToLast(int key){
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int current = queue.poll();
            if (current != key) {
                queue.offer(current);
            }
        }
        queue.offer(key);
    
    }
}
