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
                
                stack.push(curr);
                curr = curr.left;
                
            }
            else{
                
                count = count + 1;
                TreeNode ele = stack.pop();
                if(count == k)
                    return ele.val;

                curr = ele.right;
            }   
        }
        return Integer.MAX_VALUE;
    }
}