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
        List<Integer> traverse = new ArrayList<>();
        preorderTraversal(root, traverse);
        return traverse;
    }
    
    public void preorderTraversal(Node root, List<Integer> traverse){
        
        if(root == null)
            return;
        
        traverse.add(root.val);
        
        List<Node> childrens = root.children;
        for(Node currChild : childrens)
            preorderTraversal(currChild, traverse);
        
        return;
        
    }
}