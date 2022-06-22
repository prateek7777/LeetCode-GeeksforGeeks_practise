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
class Pair{                            //class.
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){      //constructor.
        this.node = node;              //initialization.  
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
 
    if(root == null)                    //edge case.
        return 0;
        
    int ans = Integer.MIN_VALUE;                        
    Queue<Pair> que = new LinkedList<>();    
     
    que.add(new Pair(root, 0));         //add something.
    //start BFS.
    while(!que.isEmpty()){
        int currLevelSize = que.size();
        int first = 0;
        int last = 0;
        int nMin = que.peek().num;            //the minimum value(index) present at each level of the binary tree. peek() brings out top element and queue is FIFO.
        for(int i = 0; i<currLevelSize; i++)    //iterating through the level from left to right.
        {
          Pair currPair = que.remove();         //remove something.
          TreeNode currNode = currPair.node;
          int currIndex = currPair.num;
          currIndex = currIndex - nMin;         //to avoid overflow.
                                                //do something.
          if(i == 0)        
              first = currIndex;                //first node in the level(from left)
          if(i == currLevelSize-1)
              last = currIndex;                 //last node in the level(from left)
            
          if(currNode.left != null)             //process children.
              que.add(new Pair(currNode.left, currIndex*2+1));      //as per the 0-indexed calculation, the index of the left node.
          if(currNode.right != null)
              que.add(new Pair(currNode.right, currIndex*2+2));     //as per the 0-indexed calculation, the index of the right node.
        }
        
        ans = Math.max(ans, last-first+1);    //(last-first+1) denotes the width of the current level of the binary tree.
    }    
   
    return ans;
    }
}