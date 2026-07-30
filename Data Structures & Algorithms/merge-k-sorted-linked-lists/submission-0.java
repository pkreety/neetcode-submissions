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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a,b)-> a.val - b.val);
        for(ListNode list: lists){
            while(list!=null){
                queue.add(list);
                list = list.next;
            }
           
        }
        ListNode result = new ListNode();
        ListNode head = result;

        while(!queue.isEmpty()){

            ListNode current = queue.poll();
            result.next = current; 
            result = result.next;

        }

        return head.next;


    }
}
