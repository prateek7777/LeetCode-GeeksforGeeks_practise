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
    List<Integer> arr = new ArrayList<>();          //array list.
    
    public void inorder(TreeNode root){
    //inorder traversal will create a sorted array.
    if(root == null)        
        return;
        
    inorder(root.left);
        
    arr.add(root.val);      //adding the manipulated(sorted) data to the array list.
        
    inorder(root.right);
        
    return;
    
    }
    
    public TreeNode createBST(int start, int end){
        //postorder traversal is used as the root is the last thing to be created.
        if(start > end)                                //base case for returning.
            return null;
        
        int mid = start + (end-start)/2;               //mid is calculated this way!
        
        TreeNode left = createBST(start, mid-1);       //binary search.
        TreeNode right = createBST(mid+1, end);
        
        int data = arr.get(mid);                       //getting the sorted data.
        
        TreeNode node = new TreeNode(data, left, right);    //creating a node using the binary searched and the sorted data.
        
        return node;                                    //returning the created node.
        
    }
    
    public TreeNode balanceBST(TreeNode root) {        //this is like the main function.
        
        TreeNode rootN = null;
        
        if(root == null)                               //base case.
            return rootN;
        
        inorder(root);                                 //creating the sorted array list.
        
        rootN = createBST(0, arr.size()-1);            //the rootN is created by the createBST func. which returns the root as the root is the last thing to be processed in the createBST func.
        
        return rootN;                                  //returning the root of the balanced BST.
  
    }
}