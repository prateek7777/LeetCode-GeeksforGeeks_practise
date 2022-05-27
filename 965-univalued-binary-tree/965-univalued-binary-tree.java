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
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        
        int considerVal = root.val;
        
        q.add(root);                                             //add something.
        //start BFS.
        while(!q.isEmpty()){

                TreeNode currNode = q.remove();                  //remove.
                
                if(currNode.val != considerVal)                 //do something according to the question.
                    return false;
            
                if(currNode.left != null)                        //process children.
                    q.add(currNode.left);
                
                if(currNode.right != null)
                    q.add(currNode.right);
                    
            }

        return true;                                  //if we come out of the loop without returning false, the tree is Univalued.

    }
}