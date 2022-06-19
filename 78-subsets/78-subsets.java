class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), allSubsets);
        return allSubsets;
    }
    
    public void generateSubsets(int[] nums, int currIndex, List<Integer> currSubset, List<List<Integer>> allSubsets){
        
        if(currIndex >= nums.length){ //base case. (it runs multiple times for every end of the recursive call).
            allSubsets.add(new ArrayList<>(currSubset)); //allSubsets.add(currSubset) will lead to allSubsets = {[],[],[],[]}, because the same memory location will keep getting updated for every
            return; //recursive call. it will be empty because of lines 15 and 17. adding the new keyword will allocate a different memory location to currSubset for every recursive call.
        }
        
        currSubset.add(nums[currIndex]);  //adding the number to the current subset.
        generateSubsets(nums, currIndex+1, currSubset, allSubsets); //the "consider array number" function call.
        currSubset.remove(currSubset.size()-1); //removing the number to avoid an output like: allSubsets = {[1,2,2], [1,2,2], [1,2,2], [1,2,2]}.
        //there will be no difference in the consider and the not consider function call.
    
        generateSubsets(nums, currIndex+1, currSubset, allSubsets);  //the "not consider array number" function call.
        //the consider and the not consider function call will be different because of the contains of currSubset list, which is because of lines 15 and 17.
        
    }
}