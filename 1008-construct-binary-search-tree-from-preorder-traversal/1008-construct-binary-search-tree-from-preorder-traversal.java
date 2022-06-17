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
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, new int[]{0}, 1001);           //boundVal because the maximum possible value of preorder[] is 1000.
    }
     
    public TreeNode buildBST(int[] preorder, int[] preorderPointer, int boundVal){
        //preorderPointer is used as pointer for the preorder array.
        if(preorderPointer[0] >= preorder.length || preorder[preorderPointer[0]] > boundVal)    //base case.
            return null;
        
        TreeNode newNodeBST = new TreeNode(preorder[preorderPointer[0]]);                       //creating the root of the BST.
        preorderPointer[0] = preorderPointer[0] + 1;                                            //iterating the pointer.
        
        newNodeBST.left = buildBST(preorder, preorderPointer, newNodeBST.val-1);                //(boundVal = newNodeBST.val-1) acc. to BST for left subtree.
        newNodeBST.right = buildBST(preorder, preorderPointer, boundVal);                       //boundVal = boundVal/Integer.MAX_VALUE acc. to BST for right subtree.
        
        return newNodeBST;                                                                      //returning the root of the BST created.
    
    }
    
}