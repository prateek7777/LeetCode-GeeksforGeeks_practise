/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
            //Serialize: tree to string.
            //Deserialize: string to tree.
        if(root == null)   //edge case.
            return "";
        
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();    //StringBuilder is mutable.
        
        q.add(root);   //add something.
        //start BFS. (Level Order Traversal).
        while(!q.isEmpty()){
            
            TreeNode node = q.remove();           //remove something.
            
            if(node == null){                     //do something.
                result.append("n ");
                continue;              //continue until null node is getting encountered.
            }
            
            result.append(node.val + " ");   //if the node is not null.
            
            q.add(node.left);               //process children.
            q.add(node.right);
  
        }
        return result.toString();            //return type is string.
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         
         if(data == "")              //edge case.
             return null;
        
         Queue<TreeNode> q = new LinkedList<>();     
         String[] parts = data.split(" ");          //don't create a new string array.
        
          TreeNode root = new TreeNode(Integer.parseInt(parts[0]));   //the first element of the string array will be the root.
          q.add(root); 
          //level order traversal.
          while(!q.isEmpty()){
              for(int i = 1; i<parts.length; i++){      //start with 1 as the root has already been assigned with parts[0].
                  
                TreeNode curr = q.remove();
                    
                if(!(parts[i].equals("n"))){            //if the element is not null.
                    
                    TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                    curr.left = left;
                    q.add(curr.left);                    //for the next iteration.
                    
                }  
                  //if the element is null, then just leave it as is, it will be null in the tree as well.
                  if(!(parts[++i].equals("n"))){        //pre-increment for the next iteration.(right).
                  
                    TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                    curr.right = right;
                    q.add(curr.right);                   //for the next iteration.
              }
                  
          }
          }
        
    return root;       //as per the problem.
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));