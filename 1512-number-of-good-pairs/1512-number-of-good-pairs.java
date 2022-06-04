class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int temp = 0;
        int answer = 0;
        
        for(int i : nums){                //iterating through the array.
            
            if(memo.containsKey(i)){      //if the number has repeated.
                temp = memo.get(i);       //get the count(occurences) of that number.
                answer = answer + temp;   //add the number of occurences of that number to the total number of occurences.
                memo.put(i, temp+1);      //increment the occurence of that number by 1. 
            }
            else
                memo.put(i, 1);           //if the number hasn't been encountered before, then it's occurence is set to 1.
            
        }

        return answer;                    //returning the final answer.
    }
}