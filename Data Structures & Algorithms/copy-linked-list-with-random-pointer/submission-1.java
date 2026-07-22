/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Node copyHeadstart = new Node(-1); 
        Node copyHead = copyHeadstart;
        Node startHead = head;
        HashMap<Node, Node> map = new HashMap();

        while(startHead!=null){
            Node newnode = new Node(startHead.val);
            copyHead.next = newnode;
            map.put(startHead, newnode);
            copyHead = copyHead.next;
            startHead = startHead.next;
        }
        Node copyHeadstartRandom = copyHeadstart; 
        Node copyHeadRandom = copyHeadstart.next;

        while(head!=null){
            if(head.random == null){
                copyHeadRandom.random = null;
            } else {
                copyHeadRandom.random = map.get(head.random);
            }
            copyHeadRandom = copyHeadRandom.next; 
            head = head.next; 

        }

        return copyHeadstartRandom.next;


        
    }
}
