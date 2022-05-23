// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
			    Solution tree = new Solution();
                ArrayList<Integer> arr = tree.rightView(root);
                for(int x : arr)
                System.out.print(x +" ");
		        System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/


class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) {
        //add code here.
        ArrayList<Integer> answer = new ArrayList<>();
        rightSideView(node, 0, answer);                   //we start at level 0 of the Binary Tree.
        return answer;
    }
    
    public void rightSideView(Node node, int currLevel, ArrayList<Integer> answer){
        
        if(node == null)                                //base case.
        return;
        //we can use answer.size() method instead of a HashMap.
        if(answer.size() == currLevel){  //if the size and the currLevel are same, it indicates that the there is no data at that point.
            answer.add(node.data);        //thus, we add the data at that point. we cannot add data at that point if that point is already populated.
        }
        
        rightSideView(node.right, currLevel+1, answer);   //we start going recursively in the right side first as we need to find the right view of Binary Tree.
        rightSideView(node.left, currLevel+1, answer);    //in left view of Binary Tree, this line would be at 148. while the above line would be here.
        //SC of HashMap method = O(N); SC of this method = O(1).
        return;
    }
}

