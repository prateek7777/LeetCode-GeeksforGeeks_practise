class Solution {
    public int subarraySum(int[] nums, int k) {
        
    int answer = 0;
    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    int prefixSum = 0;
    
    memo.put(prefixSum, 1);                   //to handle edge cases.
    for(int currVal : nums){
        
    prefixSum = prefixSum + currVal;          //prefixSum is the sum of all the elements(of the array) behind it.
    
    if(memo.containsKey(prefixSum-k)){               //(prefixSum-k) represents that the sum of the array elements behind prefixSum is equal to k.
        answer = answer + memo.get(prefixSum-k);     //we update the answer ONLY as the above condition verifies that it satisfies the required condition.
    }                                                //see last.
        
    if(memo.containsKey(prefixSum))                  //if the prefixSum is repeating.
        memo.put(prefixSum, memo.get(prefixSum)+1);
        
    else
        memo.put(prefixSum, 1);                      //if the prefixSum is encountered for the first time.
    }
    return answer;                             //we return the final answer.
        
    }
    //see last.
    //nums[] = [1,1,1,1,1,1]; k = 3.
    //prefixSum = 3.(3-3=0), answer = 1(because, memo(0)=1(edge case handler). memo(3)=1; prefixSum = 6.(6-3=3), answer = 2(1+1)(because, memo(3)=1). memo(6)=1; so on.
    
}