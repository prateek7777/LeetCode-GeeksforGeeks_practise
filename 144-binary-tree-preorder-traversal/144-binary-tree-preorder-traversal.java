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
        
        if(root == null)                                             //because null.val cannot be computed in line 28.
            return answer;
        
        stack.push(root);                              //starting with pushing the root.
        
        while(!stack.isEmpty()){
         TreeNode currNode = stack.pop();           //as per the explanation, we put topmost element in stack in the answer list.
            answer.add(currNode.val);               //adding the value in the answer list.
            
            if(currNode.right != null)              
                stack.push(currNode.right);           //It is Node, LC, RC in preorder. But, since we are using the stack DS instead of recursive stack,
                                                    //we have to do Node, RC, LC.
            if(currNode.left != null)
                stack.push(currNode.left);          //explained above.
        }
    return answer;        
    }
}