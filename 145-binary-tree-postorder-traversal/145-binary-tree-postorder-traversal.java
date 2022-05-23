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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root == null)                                             //because null.val cannot be computed in line 28.
            return answer;
        
        stack.push(root);                              //starting with pushing the root.
        
        while(!stack.isEmpty()){
         TreeNode currNode = stack.pop();           //as per the explanation, we put topmost element in stack in the answer list.
            answer.add(currNode.val);               //adding the value in the answer list.
            
            if(currNode.left != null)              //as per postorder, required ouput order: LC, RC, Node.
                stack.push(currNode.left);           
            
            if(currNode.right != null)
                stack.push(currNode.right);          
        }
        //after the while loop, the order in the answer list would be Node, RC, LC.
        Collections.reverse(answer);               //thus, we reverse the list for getting the requried output. 
        return answer;    
    }
}