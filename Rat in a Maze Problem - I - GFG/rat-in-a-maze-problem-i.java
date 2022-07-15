// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] grid, int n) {
        // Your code here
        ArrayList<String> allPaths = new ArrayList<>();
        findAllPaths(grid, 0, 0, n, "", allPaths);       //recursive call.
        return allPaths;
    }
    //square matrix of order n*n.
    public static void findAllPaths(int[][] grid, int currRow, int currCol, int n, String currPath, ArrayList<String> allPaths){
        //as per question, grid[][] = 0 is invalid. grid[][] = -1 implies that it has been already visited. other conditions are for index bounds.
        if(currRow < 0 || currRow >= n || currCol < 0 || currCol >=n || grid[currRow][currCol] == 0 || grid[currRow][currCol] == -1){
            return;
        }
        
        if(currRow == n-1 && currCol == n-1)      //the last element of the matrix grid.(required point to be reached.)
        {
            allPaths.add(currPath); //adding the path to the list allPaths. //for every recursive call, a new currPath will be added.
            return;
        }
        
        grid[currRow][currCol] = -1;   //indicating that this element has been reached/the rat has already went over.         //choose.
        //the current path is in lexicographical order.
        findAllPaths(grid, currRow+1, currCol, n, currPath + "D", allPaths);    //down.                                       //explore.
        findAllPaths(grid, currRow, currCol-1, n, currPath + "L", allPaths);    //left.
        findAllPaths(grid, currRow, currCol+1, n, currPath + "R", allPaths);    //right.
        findAllPaths(grid, currRow-1, currCol, n, currPath + "U", allPaths);    //up.
        
        grid[currRow][currCol] = 1;     //backtrack, that is undo the change.                                                   //unchoose.
   
    }
    
}