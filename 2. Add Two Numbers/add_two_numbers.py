class ListNode:
    """Definition for a singly-linked list"""

    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    """
    You are given two non-empty linked lists representing two non-negative
    integers. The digits are stored in reverse order and each of their nodes
    contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the
    number 0 itself.

    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
    """

    def naive_add_two_numbers(self, l1, l2):
        """
        Essentially taking one step at a time. We start with assigning the
        first node. Then we loop until one of the linked lists is None. Then we 
        individually loop through the remaining linked list. Finally, we add
        a carry if there is one.
        Time Complexity: O(n)
        """
        carry = 0
        head = None

        if l1.val + l2.val < 10:
            head = ListNode(l1.val + l2.val)
        else:
            head = ListNode((l1.val + l2.val) % 10)
            carry = 1

        curr = head

        while l1.next is not None and l2.next is not None:

            if l1.next.val + l2.next.val + carry < 10:
                curr.next = ListNode(l1.next.val + l2.next.val + carry)
                carry = 0
            else:
                curr.next = ListNode((l1.next.val + l2.next.val + carry) % 10)
                carry = 1
            l1 = l1.next
            l2 = l2.next
            curr = curr.next

        while l1.next is not None and l2.next is None:
            if l1.next.val + carry < 10:
                curr.next = ListNode(l1.next.val + carry)
                carry = 0
            else:
                curr.next = ListNode((l1.next.val + carry) % 10)
                carry = 1

            l1 = l1.next
            curr = curr.next

        while l1.next is None and l2.next is not None:
            if l2.next.val + carry < 10:
                curr.next = ListNode(l2.next.val + carry)
                carry = 0
            else:
                curr.next = ListNode((l2.next.val + carry) % 10)
                carry = 1

            l2 = l2.next
            curr = curr.next

        if carry == 1:
            print("HERE")
            curr.next = ListNode(1)

        return head

    def add_two_numbers(self, l1, l2):
        """
        This implementation is much cleaner and requires only a single pass. We
        make use of the modulo operator more efficiently to track our carry
        variable.
        Time Complexity: O(n)
        """
        head = curr = ListNode((l1.val + l2.val) % 10)
        carry = (l1.val + l2.val) // 10
        while l1.next or l2.next or carry:
            if l1.next:
                carry += l1.next.val
                l1 = l1.next
            if l2.next:
                carry += l2.next.val
                l2 = l2.next
            curr.next = ListNode(carry % 10)
            carry //= 10
            curr = curr.next
        return head

if __name__ == "__main__":
    s = Solution()

    l1_a = ListNode(2)
    l1_b = ListNode(4)
    l1_c = ListNode(3)
    l1_a.next = l1_b
    l1_b.next = l1_c

    l2_a = ListNode(5)
    l2_b = ListNode(6)
    l2_c = ListNode(4)
    l2_a.next = l2_b
    l2_b.next = l2_c

    curr = s.add_two_numbers(l1_a, l2_a)

    while curr != None:
        print(curr.val) # -> 7 > 0 > 8
        curr = curr.next
