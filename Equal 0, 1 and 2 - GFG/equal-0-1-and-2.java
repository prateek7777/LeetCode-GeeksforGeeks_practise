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
        
        int z0 = 0;
        int z1 = 0;
        int z2 = 0;
        long answer = 0;
        int n = str.length();
        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        //the expression has been made considering the proportionality factor.
        String expr_consider = (z2-z1) + "-" + (z1-z0); //the brackets are important. //expression can be anything(z0-z1, z1-z2; etc).
        
        memo.put(expr_consider, 1);                       //to handle edge cases in most HashMap problems.
        
        for(int i=0; i<n; i++){
            
            if(str.charAt(i)=='0')                       //as per the requirement of the question.
            z0 = z0+1;                             
            else if(str.charAt(i)=='1')
            z1 = z1+1;
            else
            z2 = z2+1;
            
            expr_consider = (z2-z1) + "-" + (z1-z0);    //the expression has to be initialized once as this is inside of a for loop.
            if(memo.containsKey(expr_consider))
            {
            answer = answer + memo.get(expr_consider); //firstly, update the answer variable.(because the answer has to be updated considering line 34). //not answer = answer+1.
            memo.put(expr_consider, memo.get(expr_consider)+1); //secondly, then update the HashMap.  //increase the frequency in the HashMap.
            }
            else
            memo.put(expr_consider, 1);                                 //the expression has been encountered for the first time.
            
        }
            return answer;
    }
} 