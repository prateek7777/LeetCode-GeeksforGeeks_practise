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
class Pair{                                       //creating the class.
    TreeNode node;
    TreeNode parent;
    Pair(TreeNode node, TreeNode parent){         //creating the constructor.
        this.node = node;                         //creating the objects.
        this.parent = parent;
    }
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> q = new LinkedList<>();                              //Queue<Pair>, not Queue<TreeNode>
        TreeNode parentOfx = null;                                       //initializing the parents of x and y.
        TreeNode parentOfy = null;
        
        q.add(new Pair(root, new TreeNode(-1)));               //add dummy node as "-1" as parent of root.  //add something.
        //start BFS.
        while(!q.isEmpty()){        
        int currLevelSize = q.size();
        
        for(int i = 0;i<currLevelSize; i++){          //using for loop instead of while loop.
            
            Pair currPair = q.remove();               //remove something.
            TreeNode currNode = currPair.node;        
            TreeNode currParent = currPair.parent;
            
            if(currNode.val == x)                            //do something.
                 parentOfx = currParent; 
            
            if(currNode.val == y)
                parentOfy = currParent;
            
            if(currNode.left != null)                         //processing the children.
                q.add(new Pair(currNode.left, currNode));
            
            if(currNode.right != null)
                q.add(new Pair(currNode.right, currNode));
            }
            //each for loop iteration represents a level in the tree, so no need to maintain a currLevel variable.
            
            if(parentOfx != null && parentOfy != null){            //do something more.
                if(parentOfx.val == parentOfy.val)
                    return false;
                else
                    return true;
            }
            if(parentOfx != null || parentOfy != null)
                return false;
        }
        return false;                                         //the queue never gets empty. this statement is never reached.
        }
    }