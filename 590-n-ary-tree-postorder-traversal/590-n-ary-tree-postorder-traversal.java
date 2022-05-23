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
    public List<Integer> postorder(Node root) {
         List<Integer> answer = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        
        if(root == null)                                             //because null.val cannot be computed in line 32.
            return answer;
        
        stack.push(root);                              //starting with pushing the root.
        
        while(!stack.isEmpty()){
            Node currNode = stack.pop();           //as per the explanation, we put topmost element in stack in the answer list.
            answer.add(currNode.val);               //adding the value in the answer list.
            
           List<Node> childrens = currNode.children;
           for(int i = 0; i<childrens.size(); i++){      //iterating through the list from left to right.
             Node currChild = childrens.get(i);      //preorder traversal: Node, left to right. postorder traversal: left to right, Node.
             stack.push(currChild);
           }
        }
    Collections.reverse(answer);                //order in the answer list: Node, lr, lr, lr; after reversing, order in the list: left to right, Node.(as per the requirement.)
    return answer;   
    }
}