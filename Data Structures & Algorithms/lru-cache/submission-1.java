class LRUCache {
    Map<Integer, Integer> map;
    int size;
    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
                return size() > size;
            }
        };
        this.size = capacity;
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
