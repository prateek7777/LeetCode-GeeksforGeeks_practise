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
    public int sumEvenGrandparent(TreeNode root) {
        int[] sum = new int[1];
        sumCalculateDfs(root, sum);
        return sum[0];
    }
    public int sumCalculateDfs(TreeNode root, int[] sum){
        //root is the grandfather.
        if(root == null)            //the grandfather itself is null.
            return 0;
        
        if(root.val%2 == 0){     //grandfather.
        
            if(root.left != null){ //father
                sum[0] = sum[0] + value(root.left.left) + value(root.left.right);    //grandchildren.
            }
            if(root.right != null){
                sum[0] = sum[0] + value(root.right.left) + value(root.right.right);  //grandchildren.
            }
            
        }
        sumCalculateDfs(root.left, sum);         //going ahead.
        sumCalculateDfs(root.right, sum);        //going ahead.
        return sum[0];
    }
    
    public int value(TreeNode root){         //used for avoiding (null.val) error.
        if(root == null)                     //checking for leaf node.
            return 0;
        else
            return root.val;                 //avoiding (null.val) error.
    }
}