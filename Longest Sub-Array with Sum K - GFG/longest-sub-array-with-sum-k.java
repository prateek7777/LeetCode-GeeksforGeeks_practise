// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}


            

// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
    int answer = 0;
    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    int prefixSum = 0;
    
    memo.put(prefixSum, -1);                   //to handle edge cases.
    for(int i = 0; i<N; i++){
        
    prefixSum = prefixSum + A[i];          //prefixSum is the sum of all the elements(of the array) behind it.
    
    if(memo.containsKey(prefixSum-K)){               //(prefixSum-k) represents that the sum of the array elements behind prefixSum is equal to k.
        answer = Math.max(answer, i-memo.get(prefixSum-K)); //we update the answer ONLY as the above condition verifies that it satisfies the required condition.
    }                                              
        
    if(!(memo.containsKey(prefixSum)))                  //if the prefixSum is repeating.
        memo.put(prefixSum, i);
    // else
    //     memo.put(prefixSum, i);                      //if the prefixSum is encountered for the first time.
    }
    return answer;                             //we return the final answer.
        
    }

    }
