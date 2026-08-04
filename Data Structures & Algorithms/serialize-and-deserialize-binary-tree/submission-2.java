/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        constructTree(root, sb);
        return sb.toString();
        
    }

    public void constructTree(TreeNode root, StringBuilder sb) {

        if(root == null){
            sb.append("null");
            sb.append(",");
            return;
        }

        sb.append(root.val);
        sb.append(",");

        constructTree(root.left, sb);
        constructTree(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       // System.out.println(data)2
        data = data.substring(0,data.length() - 1);
        System.out.println(data);
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        //String[] list = data.split(",");
       // TreeNode root = new TreeNode(queue.poll()); //1
        return buildTree(queue);


       
    }

    public TreeNode buildTree(Queue<String> queue){

    
        String val = queue.poll();
        if(val == null || val.equals("null")){
            return null;
        }
        TreeNode current = new TreeNode(Integer.parseInt(val)); //1   
        current.left = buildTree(queue);
        current.right = buildTree(queue);

        return current;

    }
}
