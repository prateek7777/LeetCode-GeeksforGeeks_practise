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
class Pair{            //creating a class.
    TreeNode p;
    TreeNode q;
    
    Pair(TreeNode p, TreeNode q){           //creating a constructor.
        this.p = p;                         //creating the objects.
        this.q = q;
    }
}
class Solution {
    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        Queue<Pair> queue = new LinkedList<>();                  //don't use 'q' as the Queue name, it throws an error ahead, that q has already been declared.
        
        queue.add(new Pair(t1, t2));         //add something
        //start BFS.
        while(!queue.isEmpty()){
            
        Pair currPair = queue.remove();        //remove something.
        
        TreeNode  p = currPair.p;
        TreeNode  q = currPair.q;
            
        if(p == null && q == null)              //do something.
            continue;
            
        if(p == null || q == null || p.val != q.val)
            return false;
            
        if(p.left != null || q.left != null)             //process children.
            queue.add(new Pair(p.left, q.left));
            
        if(p.right != null || q.right != null)
            queue.add(new Pair(p.right, q.right));
    }
        return true;                  
    }    //lot of edge cases are there!!
}
        