class Solution {
    /**
     * Returns a sorted linked list.
     * 
     * Put the first node of each linked list into a priority queue (min-heap). As
     * you pop from the queue, enqueue the next node onto the queue.
     * 
     * Time complexity: O(nk log k)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        ListNode head = new ListNode(0);
        ListNode l = head;

        for (ListNode list : lists) {
            if (list != null) {
                q.add(list);
            }
        }

        while (q.size() != 0) {
            ListNode n = q.remove();
            l.next = n;
            if (n.next != null) {
                q.add(n.next);
            }
            l = l.next;
        }
        return head.next;
    }
}