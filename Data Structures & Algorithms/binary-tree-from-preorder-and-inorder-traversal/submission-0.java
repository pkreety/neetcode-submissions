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
        //TreeNode root = preorder[0];

        return constructTreeFromPreOrder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        //return root;
    }

    public TreeNode constructTreeFromPreOrder(int[] preorder, int startPreOrder, int endPreorder, int[] inorder, int startinorder, int endInorder){
        if(startPreOrder > endPreorder || startinorder > endInorder){
            return null;
        }

        if(startPreOrder < 0 || startinorder < 0 || endPreorder > preorder.length - 1 || endInorder > inorder.length - 1){
            return null;
        }

        
        TreeNode current = new TreeNode(preorder[startPreOrder]); // 1
        System.out.println(preorder[startPreOrder]);
        // find inIndoreder
        int inorderPos = -1;
        
        for(int i = 0; i<inorder.length; i++ ){
            if(inorder[i] == preorder[startPreOrder]){
                inorderPos  = i;   
                break;  
            }
        }
        System.out.println("inorderPos "+inorderPos);
        int elementsInLeft = inorderPos - startinorder;
        System.out.println("elementsInLeft "+elementsInLeft);
        current.left = constructTreeFromPreOrder(preorder, startPreOrder + 1, startPreOrder + elementsInLeft, inorder, startinorder, inorderPos);
        current.right = constructTreeFromPreOrder(preorder, startPreOrder + 1 + elementsInLeft, endPreorder, inorder, inorderPos +  1, endInorder);

        return current;

    }


}
