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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        
        while(!stack.isEmpty() || curr != null){
            
            if(curr != null){
                
                stack.push(curr);                       //just like recursion.
                curr = curr.left;                       //the smallest element will be on the left side.
                                                        //starting with the left subtree of the BST.
            }
            else{                                      //(curr == null) indicates that the leftmost node of the subtree has been reached.
                
                count = count + 1;                     //??
                TreeNode ele = stack.pop();             
                if(count == k)
                    return ele.val;

                curr = ele.right;                      //the next subtree on the left subtree of the BST.
            }   
        }
        return Integer.MAX_VALUE;                      
    }
}