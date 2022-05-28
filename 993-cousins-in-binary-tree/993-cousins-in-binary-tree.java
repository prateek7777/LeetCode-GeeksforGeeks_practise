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
class Pair{
    TreeNode node;
    TreeNode parent;
    Pair(TreeNode node, TreeNode parent){
        this.node = node;
        this.parent = parent;
    }
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        TreeNode parentOfx = null;
        TreeNode parentOfy = null;
        
        q.add(new Pair(root, new TreeNode(-1)));
        
        while(!q.isEmpty()){        
        int currLevelSize = q.size();
        
        for(int i = 0;i<currLevelSize; i++){
            
            Pair currPair = q.remove();
            TreeNode currNode = currPair.node;
            TreeNode currParent = currPair.parent;
            
            if(currNode.val == x)
                 parentOfx = currParent; 
            
            if(currNode.val == y)
                parentOfy = currParent;
            
            if(currNode.left != null)
                q.add(new Pair(currNode.left, currNode));
            
            if(currNode.right != null)
                q.add(new Pair(currNode.right, currNode));
                      
                      }
            
            if(parentOfx != null && parentOfy != null){
                if(parentOfx.val == parentOfy.val)
                    return false;
                else
                    return true;
            }
            
            if(parentOfx != null || parentOfy != null)
                return false;
                      
        }
        
        return false;

        }
    }