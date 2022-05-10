// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) 
                a[i] = sc.nextInt();
            

            Solution g = new Solution();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}
// } Driver Code Ends




class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N)
    {  
        int prefixSum = 0;
        int maxSubArrLen = 0;
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>(); //both prefixSum and index are integers.
        
        memo.put(prefixSum, -1);       //assign -1 to prefixSum = 0, to handle corner case.
        
        for(int i=0; i<N; i++)
        {
         
         if(arr[i]==0)
         prefixSum = prefixSum + (-1);       //instead of replacing the O's of the array with -1's, we will just add -1 to the prefixSum.  
         
         else
         prefixSum = prefixSum + 1;          //since this is a binary array, the only other number would be 1.
        
        //  prefixSum = prefixSum + arr[i]; //update prefixSum with every iteration through arr[i].
         
         if(memo.containsKey(prefixSum)) //if prefixSum was encountered earlier. The sum of elements between two same prefix sums is 0.
         maxSubArrLen = Math.max(maxSubArrLen, i - memo.get(prefixSum)); // memo.get(prefixSum) will return the index of the very first same prefixSum.
                                                                         //- i will contain the index of current prefixSum. We go from left to right.
         
         else
         memo.put(prefixSum, i); //if prefixSum encountered is new. Assign its index to it. It will be stored and used while comparing in Line 45.
         
        }
        
        return maxSubArrLen;  //return the length of the longest subarray where its sum=0.
        
        // Your code here
    }
}
