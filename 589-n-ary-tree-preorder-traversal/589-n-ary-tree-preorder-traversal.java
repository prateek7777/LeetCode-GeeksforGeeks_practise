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
        List<Integer> traverse = new ArrayList<>();               //the list which contains the traversed tree.
        preorderTraversal(root, traverse);                        //the recursive function call.
        return traverse;                                          //returning the final answer.
    }
    
    public void preorderTraversal(Node root, List<Integer> traverse){
        
        if(root == null)                                          //the base case.
            return;
//preoder traversal in Binary Tree => value, left child, right child; preorder traversal in N-ary Tree => value, left to right traversal direction of nodes.
        traverse.add(root.val);                                   //adding the value to the list.
        
        List<Node> childrens = root.children;                     //the given list.
        for(Node currChild : childrens)           //traversing through the list. the traversal list direction is from left to right.
            preorderTraversal(currChild, traverse);            //updating the list traverse with each recursive call.
        
        return; 
        
    }
}