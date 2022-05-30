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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       int[] preIndex = {0};
       HashMap<Integer, Integer> inorderMap = buildInorderMap(inorder);
       return constructTree(preorder, inorder, preIndex, 0, preorder.length-1, inorderMap); 
    }
    
    public TreeNode constructTree(int[] preorder, int[] inorder, int[] preIndex, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap){
        
        if(preIndex[0] >= preorder.length || inStart > inEnd)
            return null;
        
        int currVal = preorder[preIndex[0]];
        TreeNode currNode = new TreeNode(currVal);
        preIndex[0] = preIndex[0] + 1;
        
        int i = inorderMap.get(currVal);
        
        currNode.left = constructTree(preorder, inorder, preIndex, inStart, i-1, inorderMap);
        currNode.right = constructTree(preorder, inorder, preIndex, i+1, inEnd, inorderMap);

        return currNode;
    }
    
    public HashMap<Integer, Integer> buildInorderMap(int[] arr){   
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int i = 0; i<arr.length; i++){
            memo.put(arr[i], i);
        }
        return memo;
    }
}