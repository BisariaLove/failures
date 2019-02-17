import java.util.LinkedList;

class LRUCache {

    LinkedList<CacheObject> cache;
    int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedList();
        this.capacity = capacity;
    }

    public int  findKey(int key){
        int index =0;
        boolean found = false;

        for(CacheObject elem : cache){
            if(elem.key == key){
                found = true;
                break;
            }
            index++;
        }

        return found? index : -1;
    }

    public int get(int key) {

        int index = findKey(key);

        if(index != -1){
            CacheObject elem = cache.remove(index);
            cache.addFirst(elem);
            return elem.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        int index = findKey(key);
        if(index != -1){
            CacheObject elem = cache.remove(index);
            elem.value = value;
            cache.addFirst(elem);
            return;
        }

        if(cache.size() == capacity){
            cache.removeLast();
        }

        cache.addFirst(new CacheObject(key, value));
    }


    public static void main(String[] args){


        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));

        cache.put(2,6);
        System.out.println("null");
        System.out.println(cache.get(1));
        cache.put(1,5);
        System.out.println("null");
        cache.put(1,2);
        System.out.println("null");

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));


    }
}

class CacheObject{
    int key;
    int value;

    public CacheObject(int key, int value){
        this.key = key;
        this.value = value;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
