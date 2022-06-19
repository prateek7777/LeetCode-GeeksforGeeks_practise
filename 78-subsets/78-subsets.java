class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), allSubsets);
        return allSubsets;
    }
    
    public void generateSubsets(int[] nums, int currIndex, List<Integer> currSubset, List<List<Integer>> allSubsets){
        
        if(currIndex >= nums.length){
            allSubsets.add(new ArrayList<>(currSubset));
            return;
        }
        
        currSubset.add(nums[currIndex]);
        generateSubsets(nums, currIndex+1, currSubset, allSubsets);
        currSubset.remove(currSubset.size()-1);
        
        
        generateSubsets(nums, currIndex+1, currSubset, allSubsets);
    }
    
}