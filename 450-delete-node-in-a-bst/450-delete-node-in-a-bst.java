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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)                 //edge case.
            return null;
        
        if(key > root.val)               //acc. to BST.
            root.right = deleteNode(root.right, key);
 
        else if(key < root.val)          //acc. to BST.
            root.left = deleteNode(root.left, key);
        
        else{   //key==(root.val)                         //found the node having the value key(targetNode is root).
            
            if(root.left == null && root.right == null){    //no child(null child).
                root = null;                                //root is targetNode.
                return root;
            }
            
            if(root.left != null && root.right == null){     //only left child.
                root = root.left;                            //root is targetNode.
                return root;
            }
            
            if(root.left == null && root.right != null){     //only right child.
                root = root.right;                           //root is targetNode.
                return root;
            }
            //both left and right childs exist for the targetNode.
            TreeNode subsNode = findNextMax(root.right);      //the next max node(the very next of targetNode). 
            
            int temp = 0;
            temp = root.val;                 //swapping targetNode val and the subsNode val.
            root.val = subsNode.val;
            subsNode.val = temp;
            //right subtree, with minimum value on the left side is the next max node(inorder intuition).
            root.right = deleteNode(root.right, key);  //the node to be deleted(targetNode is on right side.) is deleted as it takes the place of the subsNode.(right subtree, extreme left).
                                                       
        }
             return root;
    }
    
    public TreeNode findNextMax(TreeNode current){
                    
           while(current.left != null)                  //going to the extreme left of the right subtree(for the subsNode).
               current = current.left;
        
        return current;
    }
}