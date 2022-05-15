// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java

class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        int answer = 0;
        int prefixSum = 0;
        int currRem = 0;
        int currVal = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        memo.put(currRem, -1);                                //to handle edge cases.
        for(int i=0; i<n; i++){
        prefixSum = prefixSum + a[i];                      //prefixSum is the sum of the elements before and including the currVal.
        currRem = ((prefixSum%k)+k)%k;                        //currRem = prefixSum%k; but to handle the negative remainders, as negative remainders cannot exist, they are converted to positive.
            
        if(memo.containsKey(currRem)){                        //if the currRem is repeating.
            answer = Math.max(answer, i - memo.get(currRem));     //answer has to be updated with the frequency of the HashMap.
            // memo.put(currRem, i - memo.get(currRem));         //increment the frequency of the HashMap for its use in further iterations.
        }
        
            if(!memo.containsKey(currRem))
            memo.put(currRem, i);                              //if the currRem has been encountered for the first time.
            
        }
        return answer;                                         //we return the final answer.
       
    }
 
}


// { Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}


  // } Driver Code Ends