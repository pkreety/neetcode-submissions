/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) { //2
       if(node == null ){
        return node;
       }

        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        LinkedList<Node> queue = new LinkedList<Node>();

        Node cloneNode = new Node(node.val); // 2
        map.put(node.val, cloneNode); 
        queue.add(node);

        while(!queue.isEmpty()){
            Node parent = queue.poll();
            Node parentclone = map.get(parent.val);
            for(Node neighbor: parent.neighbors){
                if(map.containsKey(neighbor.val)){
                    Node clonedNeighborNode = map.get(neighbor.val); 
                    parentclone.neighbors.add(clonedNeighborNode);
                } else {
                    Node clonedNeighborNode = new Node(neighbor.val);
                    map.put(neighbor.val, clonedNeighborNode);
                    parentclone.neighbors.add(clonedNeighborNode);
                    queue.add(neighbor);
                }

        }
        }

        

        return cloneNode;
        
    }
}