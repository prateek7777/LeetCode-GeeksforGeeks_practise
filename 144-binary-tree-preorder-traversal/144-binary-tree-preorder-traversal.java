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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre_traversal = new ArrayList<>();                 //this list contains the preorder traversal list.
        preTraversal(root, pre_traversal);                               //recursive function call.
        return pre_traversal;                                            //return the final traversed list.
    }
    
    public void preTraversal(TreeNode root, List<Integer> pre_traversal){
        
        if(root == null)                                                    //the base case.
            return;
        //preorder traversal => value at node, left node, right node.
        pre_traversal.add(root.val);             //recursion not needed here. //the value at the current node/root is added to the list.
        preTraversal(root.left, pre_traversal);        //recursively keep adding the left node(root), to the list.
        preTraversal(root.right, pre_traversal);       //recursively keep adding the right node(root), to the list.
        
        return;                                   //the return type is void.
    }
}