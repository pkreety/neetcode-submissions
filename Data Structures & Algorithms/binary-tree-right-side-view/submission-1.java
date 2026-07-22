class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i < size; i++){
                TreeNode node = queue.poll(); 
                if(i==0){
                     result.add(node.val);
                }            
                System.out.println(node.val);
                if(node.right!=null){
                    queue.offer(node.right);
                   
                } 
                 if(node.left != null) {
                    queue.offer(node.left);
                }

            }
        }
        return result;
    }
}