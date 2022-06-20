class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        generateCombinations(candidates, target, 0, new ArrayList<>(), output);
        return output;
    }
    
    public void generateCombinations(int[] candidates, int target, int currIndex, List<Integer> curr, List<List<Integer>> output){
        
        if(target == 0){
            output.add(new ArrayList<>(curr));       //new keyword is used to avoid output = [[],[]].
            return;
        }
        
        if(currIndex >= candidates.length)           //edge case.
            return;
        
        if(candidates[currIndex] <= target){         //consider case.
            curr.add(candidates[currIndex]);         //adding the number to the current subset.
            generateCombinations(candidates, target-candidates[currIndex], currIndex, curr, output);   //consider funtion call.
            curr.remove(curr.size()-1);    //to avoid an output like : [[1,1,1],[1,1,1,2]].
        }
        
        generateCombinations(candidates, target, currIndex+1, curr, output);       //not consider case.
    }
    
}