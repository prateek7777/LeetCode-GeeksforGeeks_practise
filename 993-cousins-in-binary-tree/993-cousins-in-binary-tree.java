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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] parents = new int[2];
        int[] levels = new int[2];
        
        areCousins(root, new TreeNode(-1), 0, x, y, parents, levels);
        
        return (parents[0] != parents[1]) && (levels[0] == levels[1]); 
    }
    
    public void areCousins(TreeNode root, TreeNode currParent, int currLevel, int x, int y, 
                           int[] parents, int[] levels){
        
        if(root == null)
            return;
        
        if(parents[0] != 0 && parents[1] != 0)
            return;
        
        if(x == root.val)
        {
            parents[0] = currParent.val;
            levels[0] = currLevel;
        }
        
        if(y == root.val)
        {
            parents[1] = currParent.val;
            levels[1] = currLevel;
        }
        
        areCousins(root.left, root, currLevel+1, x, y, parents, levels);
        areCousins(root.right, root, currLevel+1, x, y, parents, levels);

    }
    
}