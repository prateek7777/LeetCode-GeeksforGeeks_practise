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
    public int maxDepth(Node root) {
        
        if(root == null)
            return 0;
        
        int f_depth = 0;
        for(Node currNode : root.children)
            f_depth = Math.max(f_depth, maxDepth(currNode));
        
        return 1 + f_depth;
    
    }
}