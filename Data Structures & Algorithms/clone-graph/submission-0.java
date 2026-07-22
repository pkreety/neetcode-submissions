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
    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }
        
        Map<Integer, Node> visited = new HashMap<>();
        return cloneEachNode(node, new ArrayList<>(), visited);
        


        
    }

    public Node cloneEachNode(Node node, List<Node> copyNeighboursList, Map<Integer, Node> visited){
    
        Node copyNode = visited.get(node.val);
        if(copyNode == null){
            copyNode = new Node(node.val);
            visited.put(node.val, copyNode); 
            for(Node neighbour: node.neighbors){
            copyNeighboursList.add(cloneEachNode(neighbour, new ArrayList<Node>(), visited));
            }
            copyNode.neighbors = copyNeighboursList;
        }
        
        return copyNode;
    }
}