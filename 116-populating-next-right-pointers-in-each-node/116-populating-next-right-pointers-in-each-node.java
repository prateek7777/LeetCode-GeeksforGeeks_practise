/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();

        if(root == null)                           //edge case.
            return null;
        
        q.add(root);                               //add something.
        //start BFS.
        while(!q.isEmpty()){
            
        int currLevelSize = q.size();
        Node prevNode = null;                   //reinitialize prevNode with null for every level iteration.
        
        for(int i = 0; i<currLevelSize; i++){

            Node currNode = q.remove();           //remove.
            
            if(i != 0)                            //do something.
            prevNode.next = currNode;             //for i = 0; prevNode will be assigned with currNode from null(null to currNode).
            
            prevNode = currNode;          //for all the other iterations except i=0, we just assign the prevNode with currNode.
            //here prevNode is being used as the next right pointer in each node. currNode is updating prevNode. 
            if(currNode.left != null)
                q.add(currNode.left);            //process the children.
            
            if(currNode.right != null)
                q.add(currNode.right);
            
        }   
        }
        
        return root;                          //returning the root as per the requirement.
    }
}