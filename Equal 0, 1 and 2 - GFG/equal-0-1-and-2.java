// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        
        int z0 = 0;
        int z1 = 0;
        int z2 = 0;
        long answer = 0;
        int n = str.length();
        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        
        String expr_consider = (z2-z1) + "-" + (z1-z0);
        
        memo.put(expr_consider, 1);
        
        for(int i=0; i<n; i++){
            
            if(str.charAt(i)=='0')
            z0 = z0+1;
            else if(str.charAt(i)=='1')
            z1 = z1+1;
            else
            z2 = z2+1;
            
            expr_consider = (z2-z1) + "-" + (z1-z0);
            if(memo.containsKey(expr_consider))
            {
            answer = answer + memo.get(expr_consider);
            memo.put(expr_consider, memo.get(expr_consider)+1);
            }
            else
            memo.put(expr_consider, 1);
            
        }
            return answer;
    }
} 