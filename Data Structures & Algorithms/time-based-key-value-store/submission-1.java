class TimeMap {

    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, x -> new TreeMap<Integer, String>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)){
            TreeMap<Integer, String> treeMap = map.get(key);
            Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
            return (entry == null)? "": entry.getValue();
        }
        return "";
    }
}
