public class DoublyLinkedList {
    int val; 
    DoublyLinkedList next;
    DoublyLinkedList prev; 
    int key;

    public DoublyLinkedList(int val) {
        this.val = val;

    }

}


class LRUCache {

    int capacity; 
    int size= 0;
    DoublyLinkedList head = new DoublyLinkedList(-1); 
    DoublyLinkedList tail = new DoublyLinkedList(-1);
    HashMap<Integer, DoublyLinkedList> map = new HashMap();

    public LRUCache(int capacity) {
        this.capacity = capacity; 
        this.head.next = tail; 
        this.tail.prev = head;
        
    }
    
    public int get(int key) {
        if(map.get(key)== null) {
            return -1;
        }
        DoublyLinkedList node = map.get(key); 
        // update the LRU put 
        removeNode(node);
        moveNodeToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
       DoublyLinkedList current = map.get(key); 
        if(current != null){
            current.val = value;
            removeNode(current);
            moveNodeToHead(current);
            // update the LRU put so its recent
        } else {
            size++;
            current  = new DoublyLinkedList(value);
            current.key = key;
            // current.prev
            // current.nxt
            map.put(key, current);
            moveNodeToHead(current);
          //  lastNode = current;
            
            if(size>capacity){
                // remove the last one 
                map.remove(tail.prev.key);
                removeNode(tail.prev);
                --size;
            }

        }
       
    }

    public void moveNodeToHead(DoublyLinkedList current) {
        current.prev = head;
        current.next = head.next;
        head.next.prev = current;
        head.next = current;
        
        
    }

    public void removeNode(DoublyLinkedList current) {
         DoublyLinkedList prev = current.prev;
         DoublyLinkedList next = current.next;

         prev.next = next;
         next.prev = prev;  
        
        
    }
}
