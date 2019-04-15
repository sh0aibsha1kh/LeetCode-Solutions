class Solution {
    /**
     * Go through both linked lists at the same time and append the correct node to
     * a new linked list. Use a dummy head and return head.next at the end.
     * 
     * Time complexity: O(n)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        while (l1 != null) {
            l3.next = l1;
            l1 = l1.next;
            l3 = l3.next;
        }

        while (l2 != null) {
            l3.next = l2;
            l2 = l2.next;
            l3 = l3.next;
        }
        return head.next;
    }
}