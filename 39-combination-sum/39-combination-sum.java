class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        findReqdCombinations(0, candidates, target, combinations, new ArrayList<>());
        return combinations;
    }
    
    public void findReqdCombinations(int index, int[] candidates, int target, List<List<Integer>> combinations, List<Integer> ds)
    {
        if(index == candidates.length)
        {
            if(target == 0)
        {
            combinations.add(new ArrayList<>(ds));
        }
            return;
        }
        
        if(candidates[index] <= target){
            
        ds.add(candidates[index]);
        findReqdCombinations(index, candidates, target-candidates[index], combinations, ds);
        ds.remove(ds.size()-1);
            
        }
        findReqdCombinations(index+1,candidates, target, combinations, ds);

    }
    
}

//Learn BackTracking and come back.