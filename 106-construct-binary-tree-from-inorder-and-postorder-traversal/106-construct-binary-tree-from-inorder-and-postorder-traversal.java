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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //Opp. of 105.(Construct Binary Tree from Preorder and Inorder Traversal).
        int[] postIndex = {postorder.length-1}; //an integer value will not get updated with all the iterations. because it is pass by value. while the int[] value will get updated because it is pass by reference.
       HashMap<Integer, Integer> inorderMap = buildInorderMap(inorder);          //the HashMap.
       return constructTree(postorder, inorder, postIndex, 0, postorder.length-1, inorderMap);  //the function call.
    }
    
    public TreeNode constructTree(int[] postorder, int[] inorder, int[] postIndex, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap){
        
        if(postIndex[0] < 0 || inStart > inEnd)       //no elements will be there to process. hence, return null.
            return null;
        
        int currVal = postorder[postIndex[0]];             //the element at the postorder array(used for the nodes iteration).
        TreeNode currNode = new TreeNode(currVal);         //currNode at the currVal.
        postIndex[0] = postIndex[0] - 1;                   //iterate postIndex[0] with each call, use it as a pointer in the postorder array.
        
        int i = inorderMap.get(currVal);                 //get the index of the place in the inorder array, where the currVal is located.
        //the inorder array has been used to find the left and the right subtree of the given tree.
        currNode.right = constructTree(postorder, inorder, postIndex, i+1, inEnd, inorderMap);       //iterating through the right subtree FIRST.
        currNode.left = constructTree(postorder, inorder, postIndex, inStart, i-1, inorderMap);      //iterating through the left subtree SECOND.
        
        return currNode;                              //returning the node of the built tree.
    }
    
    public HashMap<Integer, Integer> buildInorderMap(int[] arr){   
        HashMap<Integer, Integer> memo = new HashMap<>();
        //the function to assign the index to each value in the inorder array. this is used above in the function call for finding the index of the currVal in the inorder array.
        for(int i = 0; i<arr.length; i++){
            memo.put(arr[i], i); 
        }
        return memo;
    }
    }