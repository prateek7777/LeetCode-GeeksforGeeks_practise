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
        
        if(root == null)                                         //edge case.
            return 0;
        
        q.add(root);                                             //add something.
        //start BFS.
        while(! q.isEmpty()){
            
            int currLevelSize = q.size();
            
            while(currLevelSize > 0){
                
                TreeNode currNode = q.remove();                  //remove.
                //we avoid doing something so as to reduce the memory usage.
                if(currNode.left != null)                        //process children.
                    q.add(currNode.left);
                
                if(currNode.right != null)
                    q.add(currNode.right);
                
                currLevelSize = currLevelSize - 1;
    
            }
            
            height = height + 1;   //each iteration represents the end of a particular level, thus incrementing the height accordingly.
            
        }
        return height;             //returning height.
    }
}