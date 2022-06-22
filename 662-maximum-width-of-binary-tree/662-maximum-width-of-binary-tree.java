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
class Pair{
    TreeNode node;
    int num;
    Pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
 
    if(root == null)
        return 0;
        
    int ans = 0;    
    Queue<Pair> que = new LinkedList<>();
    
    que.add(new Pair(root, 0));
    
    while(!que.isEmpty()){
        int currLevelSize = que.size();
        int first = 0;
        int last = 0;
        int nMin = que.peek().num;
        for(int i = 0; i<currLevelSize; i++)
        {
          int currIndex = que.peek().num - nMin;
            
          if(i == 0)
              first = currIndex;
          if(i == currLevelSize-1)
              last = currIndex;
            
          TreeNode currNode = que.peek().node;
          que.poll();
        
          if(currNode.left != null)
              que.add(new Pair(currNode.left, currIndex*2+1));
          if(currNode.right != null)
              que.add(new Pair(currNode.right, currIndex*2+2));
        }
        
        ans = Math.max(ans, last-first+1);
    }    
   
    return ans;
    }
}