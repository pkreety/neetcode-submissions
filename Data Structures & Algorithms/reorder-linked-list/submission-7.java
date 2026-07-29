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

        ListNode mid = findMid(head);
        ListNode reversed = reverseMid(mid);
        
        mid.next = null;
       

        while(head!= null && reversed!= null && head.next !=null && reversed.next!=null){
             ListNode temp = head.next;
             head.next = reversed;
             ListNode reveredTemp = reversed.next;
             reversed.next = temp;
             head = temp;    
             reversed = reveredTemp;   

        }

        
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head; 
        ListNode fast = head; 

        while(fast!=null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 
        }
        System.out.println("mid "+slow.val);
        return slow;
    }

    public ListNode reverseMid(ListNode head){

        ListNode node = null;
        while(head != null){

            ListNode current = head.next; 
            head.next = node;
            node = head;
            head = current;
        }
        System.out.println("reversed "+node.val);
        return node;
    }
}