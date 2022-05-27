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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int height = 0;
        
        if(root == null)
            return 0;
        
        q.add(root);
        
        while(! q.isEmpty()){
            
            int currLevelSize = q.size();
            
            while(currLevelSize > 0){
                
                TreeNode currNode = q.remove();
                
                if(currNode.left != null)
                    q.add(currNode.left);
                
                if(currNode.right != null)
                    q.add(currNode.right);
                
                currLevelSize = currLevelSize - 1;
    
            }
            
            height = height + 1;
            
        }
        return height;
        }
}