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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        calculateHeight(root);
        return isBalanced;
    }

    public int calculateHeight(TreeNode root){
        if(root == null){
            return 0; 
        }
        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);
        if(Math.abs(left - right)>=2){
            isBalanced = false;
        }
        return Math.max(left, right) + 1;


    }


}
