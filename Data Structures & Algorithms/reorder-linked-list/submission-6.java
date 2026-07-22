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
    public void reorderList(ListNode head) {

        ListNode slow = head; 
        ListNode fast = head.next; 

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

        }
        
        ListNode halfPoint = slow.next;
        slow.next = null;
        
        ListNode reversed = null;
        while(halfPoint != null){
           ListNode current = halfPoint;  // 5,6 
           halfPoint = halfPoint.next;  // 5,6
           current.next = reversed;      
           reversed = current; 
           System.out.println("reversed "+reversed.val);
        }
       
        while (reversed != null) { 
            ListNode temp = head.next; 
            head.next = reversed;
            head = temp;

            temp = reversed.next; 
            reversed.next = head;
            reversed = temp;
        }
    

        
    }
}
