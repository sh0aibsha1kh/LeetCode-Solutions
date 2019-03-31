import java.util.Map;

class LRUCache {
    int capacity;
    LinkedList linkedList;
    Map<Integer, Node> map;

    /**
     * Set the capacity of the LRUCache as well as initialize a HashMap that maps
     * keys to Nodes. Also initialize our doubly LinkedList to keep track of the
     * most recently used entry.
     */
    public LRUCache(int capacity) {
        this.linkedList = new LinkedList();
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    /**
     * If a Node is retrieved (i.e, not null), then move it to the front of the
     * LinkedList and return its value.
     */
    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
            return -1; // should handle this exception
        }
        linkedList.moveToFront(n);
        return n.value;
    }

    /**
     * If the Node already exists in the HashMap, move it to the front of the
     * LinkedList and update its value. Otherwise, verify the size of the HashMap is
     * not at capacity. If the HashMap is full, remove the tail Node from the
     * HashMap and the LinkedList. Then proceed to enter the new Node into the
     * HashMap and the LinkedList.
     */
    public void put(int key, int value) {
        Node n = map.get(key);
        if (n != null) { // this already exists in our table
            linkedList.moveToFront(n);
            n.value = value;
        } else {
            Node newNode = new Node(key, value);
            if (map.size() == capacity) {
                Node tail = linkedList.getTail();
                map.remove(tail.key);
                linkedList.removeTail();
            }
            map.put(key, newNode);
            linkedList.addToFront(newNode);
        }
    }
}

/**
 * A Doubly Linked List.
 */
class LinkedList {
    Node tempHead, tempTail;

    /**
     * Initialize a dummy head and tail to make things easier.
     */
    LinkedList() {
        tempHead = new Node(0, 0);
        tempTail = new Node(0, 0);
        tempHead.next = tempTail;
        tempTail.prev = tempHead;
    }

    /**
     * Moves an existing Node in the LinkedList to the front.
     */
    void moveToFront(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        addToFront(n);
    }

    /**
     * Adds a node to the front of the LinkedList
     */
    void addToFront(Node n) {
        Node temp = tempHead.next;
        tempHead.next = n;
        n.next = temp;
        n.prev = tempHead;
        temp.prev = n;
    }

    /**
     * Get the tail of LinkedList (which is actually one Node behind the dummy
     * tail).
     */
    Node getTail() {
        return tempTail.prev;
    }

    /**
     * Remove the tail and set the new tail to be two Nodes behind the dummy tail.
     */
    void removeTail() {
        Node newTail = tempTail.prev.prev;
        newTail.next = tempTail;
        tempTail.prev = newTail;
    }
}

/**
 * A simple Node class which has a pointer to the previous and next nodes. It
 * will be used in our Doubly LinkedList.
 */
class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}