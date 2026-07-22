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
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null; // 0
        
        while(head!=null){
            ListNode current = head; // [0,1,2,3]
            head = head.next; 
            current.next = dummy;
            dummy = current;// 0-null,2- 1- 0-null    

        }
        
        return dummy;
    }
}
