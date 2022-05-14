class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayWithAtmostK(nums, k) - subarrayWithAtmostK(nums, k-1);
    }
        public int subarrayWithAtmostK(int[] nums, int k){
        int release = 0;
		int answer = 0;
		int distinct = 0;
		int n = nums.length;
        
		HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
		
		for(int acquire = 0; acquire<n; acquire++){
		    
		    int currInt = nums[acquire];       //required.
		    
		    if(memo.containsKey(currInt))            //if repeating.
		        memo.put(currInt, memo.get(currInt)+1);
		        
		    else
		    {
		        memo.put(currInt, 1);                 //not repeating, first time.
		        distinct = distinct + 1;           //since, first time encounter, increment distinct.
		    }
		                             
		    while(release<=acquire && distinct > k){     //as per the question.
		        
		        int discardInt = nums[release];    //required
		        release = release + 1;                     //incrementing release as it has come inside the loop meaning, that the 
		        //previous ints should be released until the valid condition is reached, i.e (distinct <= k)(atmost k). 		        
		        memo.put(discardInt, memo.get(discardInt)-1);  //decrementing the frequency without if loop as while in itself is 
//a condition that checks the credibility.		        
		        if(memo.get(discardInt) == 0)     //if frequency of int is 0, it has to be removed from the HashMap.
 		        {
		            memo.remove(discardInt);      //since we are completely removing a int(not decrementing it).
		            distinct = distinct - 1;       //since we are removing(opposite of adding), distinct count should be reduced by 1.
		        }
		        
		    }
        
		answer = answer + acquire-release+1; //the count of the valid subarray(s) is (acquire-release+1). we keep updating the answer.
		
		}
				return answer;  //returning the answer for AT MOST k.
    }
}