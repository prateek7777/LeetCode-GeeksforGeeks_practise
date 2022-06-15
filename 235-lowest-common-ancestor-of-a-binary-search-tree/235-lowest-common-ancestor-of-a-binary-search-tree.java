/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        
        while(curr != null){
            
            if(p.val > curr.val && q.val > curr.val)
                curr = curr.right;                         //acc. to BST.
            
            else if(p.val < curr.val && q.val < curr.val)
                curr = curr.left;                          //acc. to BST.
            
            else  //if p is on left and q is on right, at the very first instance, the curr is LCA.
                return curr;
        }
            return null;      //to avoid missing return statement error.
  
        }
    }