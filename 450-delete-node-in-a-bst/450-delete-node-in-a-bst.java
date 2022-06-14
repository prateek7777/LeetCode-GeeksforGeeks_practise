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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        
        if(key > root.val)
            root.right = deleteNode(root.right, key);
        
        else if(key < root.val)
            root.left = deleteNode(root.left, key);
        
        else{
            
            if(root.left == null && root.right == null){
                root = null;
                return root;
            }
            
            if(root.left != null && root.right == null){
                root = root.left;
                return root;
            }
            
            if(root.left == null && root.right != null){
                root = root.right;
                return root;
            }
            
            TreeNode subsNode = findNextMax(root.right);
            
            int temp = 0;
            temp = root.val;
            root.val = subsNode.val;
            subsNode.val = temp;
            
            root.right = deleteNode(root.right, key);
            
        }
             return root;
    }
    
    public TreeNode findNextMax(TreeNode current){
                    
           while(current.left != null)
               current = current.left;
        
        return current;
    }
}