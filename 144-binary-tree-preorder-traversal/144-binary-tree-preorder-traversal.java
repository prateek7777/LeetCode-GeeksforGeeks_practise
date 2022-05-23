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
       List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root == null)
            return answer;
        
        stack.push(root);
        
        while(!stack.isEmpty()){
         TreeNode currNode = stack.pop();
            answer.add(currNode.val);
            
            if(currNode.right != null)
                stack.push(currNode.right);
            
            if(currNode.left != null)
                stack.push(currNode.left);
        }
    return answer;
    }}