class LRUCache {
    class Node{
        int key,val;
        Node next, prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node head, tail;
    Map<Integer, Node> map;
    int cap;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        cap = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            moveToFront(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            moveToFront(node);
        }
        else{
            if (map.size()==cap){
                Node node = tail.prev;
                map.remove(node.key);
                remove(node);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToFront(node);
        }
    }
    private void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    private void moveToFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
