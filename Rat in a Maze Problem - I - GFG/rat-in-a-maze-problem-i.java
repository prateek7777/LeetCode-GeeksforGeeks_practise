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
        findAllPaths(grid, 0, 0, n, "", allPaths);
        return allPaths;
    }
    
    public static void findAllPaths(int[][] grid, int currRow, int currCol, int n, String currPath, ArrayList<String> allPaths){
        
        if(currRow < 0 || currRow >= n || currCol < 0 || currCol >=n || grid[currRow][currCol] == 0 || grid[currRow][currCol] == -1){
            return;
        }
        
        if(currRow == n-1 && currCol == n-1)
        {
            allPaths.add(currPath);
            return;
        }
        
        grid[currRow][currCol] = -1;
        
        findAllPaths(grid, currRow+1, currCol, n, currPath + "D", allPaths);
        findAllPaths(grid, currRow, currCol-1, n, currPath + "L", allPaths);
        findAllPaths(grid, currRow, currCol+1, n, currPath + "R", allPaths);
        findAllPaths(grid, currRow-1, currCol, n, currPath + "U", allPaths);
        
        grid[currRow][currCol] = 1;
   
    }
    
}