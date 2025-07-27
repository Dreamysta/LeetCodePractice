import java.util.HashMap;
import java.util.Map;

public class LeetCode146{

    class  DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(){}

        public DLinkedNode(int _key,int _value){
            key = _key;
            value = _value;
        }
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public LeetCode146(int capacity){
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;

        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newnode = new DLinkedNode(key,value);
            cache.put(key,newnode);
            addToHead(newnode);
            size++;

            if(size > capacity){
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;           // 新节点前驱是 head
        node.next = head.next;      // 新节点后继是原来的第一个节点

        head.next.prev = node;      // 原来的第一个节点的前驱设为新节点
        head.next = node;           // head 的后继指向新节点
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next; // 上一个节点的 next 跳过当前节点
        node.next.prev = node.prev; // 下一个节点的 prev 跳过当前节点
    }


    private void moveToHead(DLinkedNode node) {
        removeNode(node);  // 从当前位置移除
        addToHead(node);   // 重新插入到头部
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev; // 找到尾节点前的最后一个有效节点
        removeNode(res);             // 从链表中移除
        return res;                  // 返回这个被删除的节点
    }

    public static void main(String[] args) {
        LeetCode146 lru = new LeetCode146(2); // 创建一个容量为 2 的 LRU 缓存

        lru.put(1, 1);                 // 缓存：[1]
        lru.put(2, 2);                 // 缓存：[2, 1]（2 最近用）
        System.out.println(lru.get(1)); // 返回 1，缓存变为：[1, 2]

        lru.put(3, 3);                 // 淘汰 2，缓存变为：[3, 1]
        System.out.println(lru.get(2)); // 返回 -1，因为 2 被淘汰了

        lru.put(4, 4);                 // 淘汰 1，缓存变为：[4, 3]
        System.out.println(lru.get(1)); // 返回 -1，因为 1 被淘汰了
        System.out.println(lru.get(3)); // 返回 3，缓存变为：[3, 4]
        System.out.println(lru.get(4)); // 返回 4，缓存变为：[4, 3]
    }
}
