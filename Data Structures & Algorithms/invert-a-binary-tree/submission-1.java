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

class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
            return root;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
          TreeNode currentNode = queue.poll();
          TreeNode temp = currentNode.left;
          currentNode.left = currentNode.right;

          currentNode.right  = temp; 
        if (currentNode.left != null)
          queue.offer(currentNode.left);
         if (currentNode.right != null)
          queue.offer(currentNode.right);
        }

        return root;
    }
}
