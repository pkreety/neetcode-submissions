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
    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }

        return isValidBSTree(root, null, null);
        
    }

    public boolean isValidBSTree(TreeNode root, Integer lo, Integer hi){
        if(root == null){
            return true;
        }

        if((lo!=null && root.val<=lo) || (hi!=null && root.val>=hi)){
            return false;

        }

        return isValidBSTree(root.left, lo, root.val) && isValidBSTree(root.right, root.val, hi);
    }
}
