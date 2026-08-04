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
     int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root == null){
            return max;
        }

        findMax(root);
        return max;
        
    }


    public int findMax(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftMax =  findMax(root.left);
        int rightMax = findMax(root.right);
        int childMax = Math.max(leftMax, rightMax); 
        int localMax = Math.max(childMax + root.val, leftMax + rightMax + root.val);
        localMax = Math.max(root.val, localMax);
        max = Math.max(localMax, max);
        return Math.max(root.val, childMax + root.val);

    }

}
