class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int answer = 0;
        int prefixSum = 0;
        int currRem = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        memo.put(currRem, 1);
        for(int currVal : nums){
        prefixSum = prefixSum + currVal;
        currRem = ((prefixSum%k)+k)%k;
            
        if(memo.containsKey(currRem)){
            answer = answer + memo.get(currRem);
            memo.put(currRem, memo.get(currRem)+1);
        }
            else
            memo.put(currRem, 1);
  
        }
        return answer;
    }
}