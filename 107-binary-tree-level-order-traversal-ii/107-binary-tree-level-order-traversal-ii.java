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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root == null)                     //corner case of null.
            return answer;
        
        q.add(root);                         //add something.
        //start BFS.
        while(!q.isEmpty()){
            List<Integer> currLevelNodes = new ArrayList<Integer>();
            
            int currSize = q.size();            //the size of the queue q represents the number of nodes at that particular level.
            
            while(currSize > 0){  //currSize represents the number of nodes at a particular level in the tree.
               //do all three operations: remove, do something, add children in this loop itself.
                TreeNode currNode = q.remove();          //remove.
                
                currLevelNodes.add(currNode.val);        //do something.
                
                if(currNode.left != null)                //add children.
                    q.add(currNode.left);
                
                if(currNode.right != null)
                    q.add(currNode.right);
                    
                currSize = currSize - 1;                  //decrementing currSize with each iteration.
            }           
                answer.add(currLevelNodes);               //coming out of the while loop represents(currSize=0) that all the nodes at a particular level have been added in the list currLevelNodes.    
        }
        Collections.reverse(answer);                      //reversing the output as per the requirement.
       return answer;                                     //when the queue q is empty, we return the final reversed answer. 
    }
}