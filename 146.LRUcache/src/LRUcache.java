import java.util.HashMap;

/**
 * @ClassName LRUcache
 * @Description TODO
 * @Author 0XuX0
 * @Date 2020/4/22
 **/
public class LRUcache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int capacity;

    public LRUcache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        //将cache中的位置提前
        put(key,val);
        return val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key,node);
        } else {
            if (cache.size() == capacity) {
                Node lastNode = cache.removeLast();
                map.remove(lastNode.key);
            }
            cache.addFirst(node);
            map.put(key,node);
        }
    }
}
