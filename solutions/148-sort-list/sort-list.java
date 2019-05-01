// Sort a linked list in O(n log n) time using constant space complexity.
//
// Example 1:
//
//
// Input: 4->2->1->3
// Output: 1->2->3->4
//
//
// Example 2:
//
//
// Input: -1->5->3->4->0
// Output: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // find mid
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1,l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 !=null || l2 != null){
            if (l1 == null) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }else if (l2 == null) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }else if (l1.val <=l2.val) {
                cur.next = new ListNode (l1.val);
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return head.next;
    }
}
