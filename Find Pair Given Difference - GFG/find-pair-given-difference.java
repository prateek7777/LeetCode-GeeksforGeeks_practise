// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        for(int i = 0; i<arr.length; i++){
        //difference between a and b = (a - b) & (b - a).
        //subtraction between a and b = (a - b). 
            if(memo.containsKey(n + arr[i]) || memo.containsKey(arr[i]-n)){    //n=a-b => a = n+b, b = a-n.
            return true;
            }
            else
            memo.put(arr[i], i);        //?? memo.put(arr[i], 1);

        }
        
        return false;                          //the entire array doesn't have the required element pairs. 
    }
}