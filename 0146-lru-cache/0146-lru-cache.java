class LRUCache {

    int capacity;
    Map<Integer, Integer> cache;
    LinkedList<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.list = new LinkedList<>();
        
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            list.remove(Integer.valueOf(key)); 
            list.addLast(key);
            return cache.get(key);
        } else {
            return -1;
        }
        
    }
    
    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            
            cache.put(key, value);
            list.remove(Integer.valueOf(key));
            list.addLast(key);
        } else {
            if (cache.size() == capacity) {
                
                int lruKey = list.removeFirst();
                cache.remove(lruKey);
            }
           
            cache.put(key, value);
            list.addLast(key);
        
    }
}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */