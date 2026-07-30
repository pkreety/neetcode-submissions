/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head; 
        ListNode slow = head; 
        ListNode prev = head;

        for(int i = 0; i < n; i++){
            fast = fast.next; 
        }
        if (fast == null) return slow.next;
        while(fast!=null){
            prev = slow;
            fast = fast.next; 
            slow = slow.next; 

        }


        prev.next = slow.next;

    return head;

    }
}
