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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return ContructTreeFromPreOrderAndInorder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);


        
    }
    public TreeNode ContructTreeFromPreOrderAndInorder(int[] preorder, int preOrderStart, int preOrderEnd, int[] inorder, int inorderStart, int inorderEnd){

        if(preOrderStart > preOrderEnd || inorderStart > inorderEnd){
            return null;
        }

        if(preOrderEnd > preorder.length -1 || inorderEnd > inorder.length - 1){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preOrderStart]);
        int inOrderPos = -1;

        for(int i = inorderStart; i <= inorderEnd; i++ ){
            if(preorder[preOrderStart] == inorder[i]){
                inOrderPos = i;
                break;
            }
        }
        int noOFElementsOnLeft = inOrderPos - inorderStart;

        root.left = ContructTreeFromPreOrderAndInorder(preorder, preOrderStart + 1, preOrderStart +noOFElementsOnLeft, inorder, inorderStart, inOrderPos);
          root.right = ContructTreeFromPreOrderAndInorder(preorder, preOrderStart + 1 + noOFElementsOnLeft, preOrderEnd, inorder, inOrderPos + 1, inorderEnd);
          return root;
    }

}
