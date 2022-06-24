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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        generateZigZag(root, answer);
        return answer;
    }
    
    public List<List<Integer>> generateZigZag(TreeNode root, List<List<Integer>> answer){
        
        if(root == null)           //edge case.
            return null;
        
        Queue<TreeNode> que = new LinkedList<>();
        boolean leftToRight = false; //start with false for this particular problem.  //should be outside the while loop, else it will influence the output.
        que.add(root);                  //add something.
        //start BFS.
        while(!que.isEmpty()){
            
            int currLevelSize = que.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0; i<currLevelSize; i++){        //level order traversal.
                
                TreeNode currNode = que.remove();       //remove something.
                
                sub.add(currNode.val);                  //do something.
                
                if(currNode.left != null)               //process children.
                    que.add(currNode.left);
                
                if(currNode.right != null)
                    que.add(currNode.right);
                
            }
                if(leftToRight == true)
                Collections.reverse(sub);               //as per the question.
                leftToRight = !leftToRight;             //toggle the boolean variable alternatively for each level.
                answer.add(sub);                        //add the sub-list to the final-list.
            
        }
    return answer;
  }

}