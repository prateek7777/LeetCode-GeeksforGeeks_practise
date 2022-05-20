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
        return isUnivalued(root, root.val);
    }
    
    public boolean isUnivalued(TreeNode root, int considerVal){
     
        if(root == null)   //we return true, because null at root, implies that we have reached the null of every node in the tree without contradicting the requirement.
            return true;  
        
        if(root.val != considerVal)                //root.val keeps on changing with each node, while considerVal only contains the value at the original root of the given tree.
            return false;                          //inequality implies that the given binary tree is not univalued.
         
        boolean leftConsider = isUnivalued(root.left, considerVal);    //consider left child.     
        boolean rightConsider = isUnivalued(root.right, considerVal);  //consider right child.
        
        if(leftConsider && rightConsider == true)                    //comparing the left child and right child.
            return true;                                             
        else
            return false;
    }
}