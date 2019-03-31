class Solution {
    /**
     * Return a copy of the original LinkedList but this time with the random
     * pointers working.
     * 
     * The idea is to do passes. The first pass will create new nodes and link them
     * with next (the regular way). The second pass will go through the new
     * LinkedList while assigning the random values.
     * 
     * Time Complexity: O(n)
     */
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node dummyHead = new Node(0, null, null);
        Node currCopy = dummyHead;
        Map<Integer, Node> map = new HashMap<>();

        /*
         * Go through the LinkedList creating new copies of the original Nodes and put
         * them in the HashMap.
         */
        while (curr != null) {
            currCopy.next = new Node(curr.val, curr.next, curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
            map.put(currCopy.val, currCopy);
        }

        currCopy = dummyHead.next; // reset currCopy

        /*
         * Use curr as the randomized pointer to assign the random values if it exists
         * in the HashMap
         */
        while (currCopy != null) {
            curr = currCopy.random;

            if (curr != null && lookup.containsKey(curr.val)) {
                currCopy.random = lookup.get(curr.val);
            }

            currCopy = currCopy.next;
        }

        return dummyHead.next;
    }
}