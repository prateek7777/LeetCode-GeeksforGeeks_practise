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
    int sum = 0;                                          //global declaration.
    public int sumOfLeftLeaves(TreeNode root) {
        sumLeftLeaves(root, false); //recursive function call. we start with false, because, the required output for tree with only one node(the 1 root) is sum = 0.
        return sum;
    }
    
    public void sumLeftLeaves(TreeNode root, Boolean isLeftLeaf){
        
        if(root == null)                                               //base case.
            return;
        
        if(root.left == null && root.right == null){               //if reached the leaf node.
            
            if(isLeftLeaf == true)                       //if the leaf is on left side.
                sum = sum + root.val;                    //keep updating the sum with the value present at the root(left leaf node).
            
        }
        
        sumLeftLeaves(root.left, true);                     //for left child, pass true to isLeftLeaf.
        sumLeftLeaves(root.right, false);                   //for right child, pass false to isLeftLeaf.
      
        return;                                           //return type is void.
    } 
}