// Given a linked list, remove the n-th node from the end of list and return its head.
//
// Example:
//
//
// Given linked list: 1->2->3->4->5, and n = 2.
//
// After removing the second node from the end, the linked list becomes 1->2->3->5.
//
//
// Note:
//
// Given n will always be valid.
//
// Follow up:
//
// Could you do this in one pass?
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // TIME O(N)
        // SPCAE O(1)
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy.next;
        ListNode fast = dummy.next;
        ListNode prev = dummy; 
        // keep nth distance between slow and fast;
        while(n != 0){
            fast = fast.next;
            n--;
        }
        // when fast at the end, then slow is the Nth node we need to remove;
        while(fast != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        // keep in mind to store the right half then break the the node;
        ListNode temp = slow;
        prev.next = null;
        prev.next = temp.next;
        return dummy.next;
    }
}
