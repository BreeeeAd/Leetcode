// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
// Example:
//
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.
//
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int carry = 0;
        while (l1 != null || l2 != null){
            int i = l1 == null ? 0:l1.val;
            int j = l2 == null ? 0:l2.val;
            int sum = carry + i + j;
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1 == null ? l1: l1.next;
            l2 = l2 == null ? l2: l2.next;
            cur = cur.next;
        }
        if (carry != 0){
            cur.next = new ListNode(carry);
        }
        return res.next;
    }
}
