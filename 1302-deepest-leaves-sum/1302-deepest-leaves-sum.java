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
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        
        if(root == null)            //base case.
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);                //add something.
        //start BFS.
        while(!q.isEmpty()){        //this while loop won't run for the last iteration.
                
            sum = 0;   //for the last stage/iteration/deepest level, the while loop won't run again, thus, the sum of the deepest leaves is found (sum won't be reset to 0).
            int size = q.size();
        
            while(size > 0){
                
            TreeNode curr = q.remove();         //remove something.
            
            sum = sum + curr.val;               //do something.
                
            if(curr.left != null)               //process children.
                q.add(curr.left);
                
            if(curr.right != null)
                q.add(curr.right);
                
             size = size-1;
                
            }
 
        }
        
        return sum;
        
    }
}