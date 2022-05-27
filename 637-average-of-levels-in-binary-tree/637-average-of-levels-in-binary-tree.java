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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> answer = new ArrayList<>();
        q.add(root);                                       //add something.
        //start BFS.
        while(!q.isEmpty()){
            
            int currLevelSize = q.size();
            int count = q.size();             //initialize count with q size.
            double total = 0;
            while(currLevelSize > 0){
                
                TreeNode currNode = q.remove();                  //remove.
                
                total = total + currNode.val;    //do something. //calculate sum at each level.
                
                if(currNode.left != null)                        //process children.
                    q.add(currNode.left);
                
                if(currNode.right != null)
                    q.add(currNode.right);
                
                currLevelSize = currLevelSize - 1;
    
            }
            
            answer.add(total/count); //currLevelSize will be 0 here, at the end of loop. // average = sum/count;
                                     //thus, currLevelSize cannot be used instead of count.
        }
        return answer;            
    }
}