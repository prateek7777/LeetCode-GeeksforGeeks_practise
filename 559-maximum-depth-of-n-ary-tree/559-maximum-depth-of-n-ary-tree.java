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
        
        if(root == null)                 //this is the base case.
            return 0;
        
        int f_depth = 0;                                         //f_depth is the maximum depth/height of this tree.
        for(Node currNode : root.children)                       //iterating through the given n-arry tree. (root.children) is required, because only "children" cannot be identified by the compiler.
            f_depth = Math.max(f_depth, maxDepth(currNode));     //we need to return the maximum of all the nodes, which represents the depth of the entire n-ary tree.
        //we don't do Math.max(f_depth, 1+maxDepth(currNode)) because the for loop won't reach until the null node, as it will stop at the very last node having data. our output will always be 1
        //less than the required output.
        
        return f_depth+1;         //thus, to add 1(the null node) to the count of the depth of the n-ary tree, we add 1 to the f_depth.
    
    }
}