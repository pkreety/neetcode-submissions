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
        System.out.println(sb.toString());
        return sb.toString();
    }

    public void constructTree(TreeNode root, StringBuilder sb) {
        if(root == null){
            sb.append(",");
            sb.append("null");
            return;
        }
        sb.append(",");
        sb.append(root.val);
        constructTree(root.left, sb);
        constructTree(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String substring = data.substring(1);
        System.out.println("substring "+substring);
        String[] val = substring.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(val));
        //Queue 
        //String[] data1 = val.trim(1, val.length);
        return buildTree(queue);
        
    }

    public TreeNode buildTree(Queue<String> queue){
        String val = queue.poll(); // 1
        if(val.equals("null")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(queue); 
        root.right = buildTree(queue);

        return root;
 

    }
}
