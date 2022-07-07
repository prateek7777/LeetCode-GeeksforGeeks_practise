class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);     //so that the required elements of candidates array are not missed at all. line 20.
        combinationSum2Helper(0, candidates, target, answer, new ArrayList<>());   //start at ind = 0.
        return answer;
    }
      
     public void combinationSum2Helper(int ind, int[] candidates, int target, List<List<Integer>> answer, List<Integer> subAnswer){
         
        if(target == 0){      //base case.
            answer.add(new ArrayList<>(subAnswer));   //new keyword is used to avoid output = [[],[]]. new memory is allocated everytime a new subAnswer is added into the answer.
            return;    //return, once the base condition is reached.
        }
            
         for(int i = ind; i < candidates.length; i++){   //ind is the point new combination starts. we iterate until the end of the candidates array.
         
             
             if(i == ind || candidates[i] != candidates[i-1]){
                if(candidates[i] > target)  //go for the next function call, because, candidates is sorted as well.
                break;
             
             subAnswer.add(candidates[i]);       //adding in the subAnswer.
             combinationSum2Helper(i+1, candidates, target-candidates[i], answer, subAnswer);  //we can put one element only once, hence, i+1.
             subAnswer.remove(subAnswer.size()-1);  //to avoid repetive elements in the subAnswer list. to avoid an output like : [[1,1,1],[1,1,1,2]].
             //as a rule of thummb, while going back(reverse order) in the function call, remove the elements according to the current situation in the function call.
             }
         }
          
     }
}