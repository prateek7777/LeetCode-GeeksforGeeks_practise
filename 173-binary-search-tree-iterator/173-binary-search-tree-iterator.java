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
class BSTIterator {
    
    public Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        pushFullLeft(root);                              //for inorder iteration.
    }
    
    public int next() {
        //inorder iteration implies that the output will be sorted.
        TreeNode currNode = stack.pop();                //LIFO. thus, the smallest element in the stack is popped.
        pushFullLeft(currNode.right);                   //only if the currNode has a right, go to its extreme left.
        return currNode.val;                            //returning the currNode.val after the extreme left is validated and all.(whether currNode.right is present or not).
        
    }
    
    public boolean hasNext() {
        if(stack.isEmpty())           //obvious.
            return false;
        else
            return true;
    }
    
    public void pushFullLeft(TreeNode node){
        
        while(node != null){
            stack.push(node);                      //important.
            node = node.left;                      //going to extreme left.
        }
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */