class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int answer = 0;
        int prefixSum = 0;
        int currRem = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        memo.put(currRem, 1);                                 //to handle edge cases.
        for(int currVal : nums){
        prefixSum = prefixSum + currVal;                      //prefixSum is the sum of the elements before and including the currVal.
        currRem = ((prefixSum%k)+k)%k;                        //currRem = prefixSum%k; but to handle the negative remainders, as negative remainders cannot exist, they are converted to positive.
            
        if(memo.containsKey(currRem)){                        //if the currRem is repeating.
            answer = answer + memo.get(currRem);              //answer has to be updated with the frequency of the HashMap.
            memo.put(currRem, memo.get(currRem)+1);           //increment the frequency of the HashMap for its use in further iterations.
        }
            else
            memo.put(currRem, 1);                              //if the currRem has been encountered for the first time.
  
        }
        return answer;                                          //we return the final answer.
    }
}