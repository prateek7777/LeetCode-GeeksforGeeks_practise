/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        if(root == null)                     //corner case of null.
            return answer;
        
        q.add(root);                         //add something.
        //start BFS.
        while(!q.isEmpty()){
            List<Integer> currLevelNodes = new ArrayList<Integer>();
            
            int currSize = q.size();            //the size of the queue q represents the number of nodes at that particular level.
            
            while(currSize > 0){  //currSize represents the number of nodes at a particular level in the tree.
               //do all three operations: remove, do something, add children in this loop itself.
                 Node currNode = q.remove();          //remove.
                
                currLevelNodes.add(currNode.val);        //do something.
                
                for(Node currChild : currNode.children)     //add children. SYNTAX.
                    q.add(currChild);
                
                currSize = currSize - 1;                  //decrementing currSize with each iteration.
            }           
                answer.add(currLevelNodes);               //coming out of the while loop represents(currSize=0) that all the nodes at a particular level have been added in the list currLevelNodes.    
        }
       return answer;                                     //when the queue q is empty, we return the final answer.
    }
}