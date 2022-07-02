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
        
        if(root == null)
            return "";
        
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            TreeNode node = q.remove();
            
            if(node == null){
                result.append("n ");
                continue;
            }
            
            result.append(node.val + " ");
            
            q.add(node.left);
            q.add(node.right);
  
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
         if(data == "")
             return null;
        
         Queue<TreeNode> q = new LinkedList<>();
         String[] parts = data.split(" ");
        
          TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
          q.add(root);
          
          while(!q.isEmpty()){
              for(int i = 1; i<parts.length; i++){
                  
                TreeNode curr = q.remove();
                    
                if(!(parts[i].equals("n"))){
                    
                    TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                    curr.left = left;
                    q.add(curr.left);
                    
                }  
                  
                  if(!(parts[++i].equals("n"))){
                  
                    TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                    curr.right = right;
                    q.add(curr.right);
              }
                  
          }
          }
        
    return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));