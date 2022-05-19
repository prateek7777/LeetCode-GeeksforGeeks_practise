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
        List<Integer> traverse = new ArrayList<>();
        postorderTraverse(root, traverse);
        return traverse;
    }
    //this is the exact opposite of preorder traversal of N-ary Tree(589).
    public void postorderTraverse(Node root, List<Integer> traverse){
        
        if(root == null)
            return;
        
        List<Node> childrens = root.children;
        for(Node currChild : childrens)
            postorderTraverse(currChild, traverse);
        
        traverse.add(root.val);
        
        return;
    }
}