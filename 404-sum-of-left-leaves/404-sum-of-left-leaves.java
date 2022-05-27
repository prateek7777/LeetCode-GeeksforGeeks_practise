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
class Pair{                               //creating the class.
    TreeNode node;
    boolean left;
    Pair(TreeNode node, boolean left){    //creating the constructor.
    this.node = node;                     //creating the objects.
    this.left = left;
    }  
}
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();           
        int total = 0;
        queue.add(new Pair(root, false));               //add something.
        //start BFS.
        while(!queue.isEmpty()){
            
        Pair currPair = queue.remove();                  //remove.
        TreeNode currNode = currPair.node;
        boolean isLeft = currPair.left;
            
        if(currNode.left == null && currNode.right == null && isLeft == true)           //do something = main logic for this problem.
            total = total + currNode.val;
            
        if(currNode.left != null)                                    //process the children.
            queue.add(new Pair(currNode.left, true));                //passing true to the left children only.
            
        if(currNode.right != null)
            queue.add(new Pair(currNode.right, false));
 
        }
        return total;                                    //return the final answer.
    }
}