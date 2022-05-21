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
        int[] parents = new int[2];          //storing the parents
        int[] levels = new int[2];           //storing the levels
        //TreeNode(-1) is a dummy node created as we cannot find null.val in line 34.
        areCousins(root, new TreeNode(-1), 0, x, y, parents, levels);
        //we start at (given root, parent of given root, current Level, x, y, parents, levels).
        return (parents[0] != parents[1]) && (levels[0] == levels[1]); //the condition to be cousins. different parents at the same level.
    }
    
    public void areCousins(TreeNode root, TreeNode currParent, int currLevel, int x, int y, 
                           int[] parents, int[] levels){
        if(root == null)                //if the root is null, we just return.
            return;
        //we want to stop as soon as parents[0] and parents[1] are populated, indicating the required information has been gained through recursion.
        if(parents[0] != 0 && parents[1] != 0)
            return;
        
        if(x == root.val)               //if the root is equal to one of the given cousins(can be true or false)(x)
        { //we use index 0 for storing the information of x.
            parents[0] = currParent.val;              //we cannot put currParent directly into parents[0] as currParent is a node.
            levels[0] = currLevel;
        }
        
        if(y == root.val)               //for y cousin.
        { //we use index 1 for storing the information of y.
            parents[1] = currParent.val;
            levels[1] = currLevel;
        }
        //the two required function calls for progressing towards left and right.
        areCousins(root.left, root, currLevel+1, x, y, parents, levels);  //root.left is going ahead in left direction. root is the parent of root.left, currLevel is incrementing as well.
        areCousins(root.right, root, currLevel+1, x, y, parents, levels); //root.right is going ahead in right direction. root is the parent of root.right, currLevel is incrementing as well.
    }
}