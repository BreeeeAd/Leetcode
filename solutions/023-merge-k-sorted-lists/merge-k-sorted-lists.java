// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
// Example:
//
//
// Input:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0); // when using dummy we always need a another pointer like cur to indecate cur position
        ListNode tail = dummy;
        PriorityQueue<ListNode> min = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
        for (ListNode ln : lists){
            if (ln != null)
            min.offer(ln);
        }
        while(!min.isEmpty()){
            tail.next = min.poll();
            tail = tail.next;
            if (tail.next != null){
                min.offer(tail.next);
            }
        }
        return dummy.next;
    }
}
