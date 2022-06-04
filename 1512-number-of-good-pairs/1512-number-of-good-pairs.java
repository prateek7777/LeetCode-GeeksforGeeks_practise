class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int temp = 0;
        int answer = 0;
        
        for(int i : nums){
            
            if(memo.containsKey(i)){
                temp = memo.get(i);
                answer = answer + temp;
                memo.put(i, temp+1);
            }
            else
                memo.put(i, 1);
            
        }

        return answer;
    }
}