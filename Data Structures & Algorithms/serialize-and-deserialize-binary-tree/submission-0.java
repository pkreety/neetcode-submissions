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

    StringBuilder sb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        buildTree(root);
        // System.out.print(sb.toString());

        return sb.toString();
        
    }

    public void buildTree(TreeNode root){

          if(root == null){
            sb.append("N");
            sb.append(",");
            return;
         }
        
             sb.append(root.val);
             sb.append(",");
           
             buildTree(root.left); 
             buildTree(root.right);     
                
    }
    //1,2,3,N,N,4,5,N,N,N,N,
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String data1 = data.substring(0, data.length() -1);
        System.out.print(data1);
        String[] sbData = data1.split(",");
        List<String> list = Arrays.asList(sbData);
        Queue<String> queue = new LinkedList<String>(list);
        return deSerializeTree(queue);
    }

    public TreeNode deSerializeTree(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("N")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deSerializeTree(queue);
        node.right = deSerializeTree(queue);
        return node;


    }
}
