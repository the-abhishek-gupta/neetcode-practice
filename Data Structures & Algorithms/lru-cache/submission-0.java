class LRUCache {
    Map<Integer, Integer> map;
    Queue<Integer> queue; 
    int size;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
        this.size = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            removeFromQueue(key);
            queue.offer(key);
            return map.get(key);
        }
        return  -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
            removeFromQueue(key);
        else if (queue.size() == size){
            int x = queue.poll();
            map.remove(x);
        }
        map.put(key, value);
        queue.offer(key);
    }

    private void removeFromQueue(int key){
        Queue<Integer> temp = new LinkedList<>();
        while (!queue.isEmpty()){
            int each = queue.poll();
            if (each == key)
                continue;
            temp.offer(each);
        }
        this.queue = temp;
    }
}
