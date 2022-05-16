class Solution {
    public int numRabbits(int[] answers) {
        double answer = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int currReportee : answers){
            
            if(memo.containsKey(currReportee))
                memo.put(currReportee, memo.get(currReportee)+1);
            
            else
                memo.put(currReportee, 1);
            
        }
        
        for(Integer currKey : memo.keySet()){
    
            double groupSize = currKey + 1;
            double numGroups = Math.ceil(memo.get(currKey)/groupSize);
            answer = answer + (numGroups*groupSize);
  
        }
            return (int)answer;
    }
}