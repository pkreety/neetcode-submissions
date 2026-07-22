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
            System.out.println("head"+head.val);
            ListNode current = head; // [0,1,2,3]
            head = head.next; 
            System.out.println("current"+current.val);
            current.next = dummy;
            dummy = current;// 0-null,2- 1- 0-null
            System.out.println(dummy.val);

        }
        
        return dummy;
    }
}
