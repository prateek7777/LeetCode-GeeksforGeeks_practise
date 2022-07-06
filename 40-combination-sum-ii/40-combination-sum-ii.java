class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(0, candidates, target, answer, new ArrayList<>());
        return answer;
    }
      
     public void combinationSum2Helper(int ind, int[] candidates, int target, List<List<Integer>> answer, List<Integer> subAnswer){
         
        if(target == 0){
            answer.add(new ArrayList<>(subAnswer));
            return;
        }
            
         for(int i = ind; i < candidates.length; i++){
         
             if(i > ind && candidates[i] == candidates[i-1])
                continue;
             if(candidates[i] > target)
                 break;
             
             subAnswer.add(candidates[i]);
             combinationSum2Helper(i+1, candidates, target-candidates[i], answer, subAnswer);
             subAnswer.remove(subAnswer.size()-1);

         }
          
     }
}