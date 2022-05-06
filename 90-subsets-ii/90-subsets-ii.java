class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answerList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), answerList);
        return answerList;
    }
    
    public static void findSubsets(int start, int[] nums, List<Integer> individualSubset, List<List<Integer>> answerList){
        
        answerList.add(new ArrayList<>(individualSubset));
        for(int i = start; i<nums.length; i++){
            if(i!=start && nums[i] == nums[i-1])
                continue;
            individualSubset.add(nums[i]);
            findSubsets(i+1, nums, individualSubset, answerList);
            individualSubset.remove(individualSubset.size()-1);
        }

    }
}