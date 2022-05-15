class Solution {
    public int subarraySum(int[] nums, int k) {
        
    int answer = 0;
    HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    int prefixSum = 0;
    
    memo.put(prefixSum, 1);
    for(int currVal : nums){
        
    prefixSum = prefixSum + currVal;
    
    if(memo.containsKey(prefixSum-k)){
        answer = answer + memo.get(prefixSum-k);
    }
        
    if(memo.containsKey(prefixSum))
        memo.put(prefixSum, memo.get(prefixSum)+1);
        
    else
        memo.put(prefixSum, 1);
    }
    return answer;
        
    }
}