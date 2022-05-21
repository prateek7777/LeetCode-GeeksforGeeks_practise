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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();              //list of strings(all the paths from root to leaves) as per the required output.
        sRootToLeaf(root, ""+Integer.toString(root.val), pathList);  //Concatenating an empty string to root.val in the recursive function call.
        return pathList;
    }
    public void sRootToLeaf(TreeNode root, String currPath, List<String> pathList){
        //after reaching the leaf node.
        if(root.left == null && root.right == null)
            pathList.add(currPath);
        
        if(root.left != null)       //until reaching the leaf(towards left)(before null) in the tree.
            sRootToLeaf(root.left, currPath + "->" + Integer.toString(root.left.val), pathList); //root.left.val, not currPath. here, currPath is getting updated in the recursive function call.
        // "->" as per the required output in the given question.
        
        if(root.right != null)     //until reaching the leaf(towards right)(before null) in the tree.
            sRootToLeaf(root.right, currPath + "->" + Integer.toString(root.right.val), pathList); //root.right.val, not currPath. here, currPath is getting updated in the recursive function call.
        // "->" as per the required output in the given question.
        
        return;            //return type is void.
        
    }
}