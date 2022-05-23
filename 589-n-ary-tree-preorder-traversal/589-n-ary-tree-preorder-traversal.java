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
    public List<Integer> preorder(Node root) {
        List<Integer> answer = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        
        if(root == null)                                             //because null.val cannot be computed in line 28.
            return answer;
        
        stack.push(root);                              //starting with pushing the root.
        
        while(!stack.isEmpty()){
            Node currNode = stack.pop();           //as per the explanation, we put topmost element in stack in the answer list.
            answer.add(currNode.val);               //adding the value in the answer list.
            
           List<Node> childrens = currNode.children;
           for(int i = childrens.size()-1; i>=0; i--){  //iterating through the list from right to left(opp. of left to right(preoder traversal)(because of stack)).
             Node currChild = childrens.get(i);
             stack.push(currChild);
           }
        }
    return answer;        
    }
}