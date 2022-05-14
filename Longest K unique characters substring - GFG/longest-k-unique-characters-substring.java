// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int release = 0;
		int answer = 0;
		int distinct = 0;
		int n = s.length();
		HashMap<Character, Integer> memo = new HashMap<Character, Integer>();
		
		for(int acquire = 0; acquire<n; acquire++){
		    
		    char currChar = s.charAt(acquire);       //required.
		    
		    if(memo.containsKey(currChar))            //if repeating.
		        memo.put(currChar, memo.get(currChar)+1);
		        
		    else
		    {
		        memo.put(currChar, 1);                 //not repeating, first time.
		        distinct = distinct + 1;           //since, first time encounter, increment distinct.
		    }
		    
		                               
		    while(release<=acquire && distinct > k){     //as per the question.
		        
		        char discardChar = s.charAt(release);    //required
		        release = release + 1;                     //incrementing release as it has come inside the loop meaning, that the 
		        //previous chars should be released until the valid condition is reached, i.e (distinct <= k)(atmost k). 		        
		        memo.put(discardChar, memo.get(discardChar)-1);  //decrementing the frequency without if loop as while in itself is 
//a condition that checks the credibility.		        
		        if(memo.get(discardChar) == 0)     //if frequency of char is 0, it has to be removed from the HashMap.
 		        {
		            memo.remove(discardChar);      //since we are completely removing a char(not decrementing it).
		            distinct = distinct - 1;       //since we are removing(opposite of adding), distinct count should be reduced by 1.
		        }
		        
		    }
        
        if(distinct == k)		    
		answer = Math.max(answer, acquire-release+1);  //the count of the valid substring(s) is (acquire-release+1).
		                                         //we keep updating the answer.
		}
		return answer == 0 ? -1 : answer;                          //we return the final answer.
    }
}