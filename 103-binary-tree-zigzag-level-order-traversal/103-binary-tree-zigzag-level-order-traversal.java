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
        List<List<Integer>> answer = new LinkedList<>();
        generateZigZag(root, answer);
        return answer;
    }
    
    public List<List<Integer>> generateZigZag(TreeNode root, List<List<Integer>> answer){
        
        if(root == null)
            return null;
        
        Queue<TreeNode> que = new LinkedList<>();
        boolean leftToRight = false;
        que.add(root);
        while(!que.isEmpty()){
            
            int currLevelSize = que.size();
            // int[] row = new int[currLevelSize];
            List<Integer> sub = new ArrayList<>();
            for(int i=0; i<currLevelSize; i++){
                
                TreeNode currNode = que.remove();
                
                sub.add(currNode.val);
                
                if(currNode.left != null)
                    que.add(currNode.left);
                
                if(currNode.right != null)
                    que.add(currNode.right);
                
            }
                if(leftToRight == true)
                Collections.reverse(sub);
                leftToRight = !leftToRight;
                answer.add(sub);
            
        }
    return answer;
  }

}