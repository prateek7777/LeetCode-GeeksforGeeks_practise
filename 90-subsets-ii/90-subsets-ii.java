class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);                                    //sorting the array, so that, the duplicate elements are adjacent to each other.
        List<List<Integer>> answerList = new ArrayList<>();                       //The syntax of ArrayList should be revised at each and every point. 
        findSubsets(0, nums, new ArrayList<>(), answerList);                      //the recursive function call.
        return answerList;                                       //returning the final answer.
    }
    
    public static void findSubsets(int start, int[] nums, List<Integer> individualSubset, List<List<Integer>> answerList){
        
        answerList.add(new ArrayList<>(individualSubset));         //for the very first empty list([]) to be added in the final answer list.
        for(int i = start; i<nums.length; i++){                    //start = 0.
            if(i>start && nums[i] == nums[i-1])                    //see last. 
                continue;                                          //this means go for the next iteration. don't consider this iteration.
            individualSubset.add(nums[i]);                         //adding the number from the array to the individual subset(list).
            findSubsets(i+1, nums, individualSubset, answerList);  //starting at (i+1), because, the number at (i) has been already added in line 15.
            individualSubset.remove(individualSubset.size()-1);    //the size of the individual subset will reach upto (=nums.length) at its maximum size. However, the for loop is running only from
        }                                                          //0 to (nums.length-1). Thus, the iteration will stop as it will come out of for loop. To avoid that, we do line 17.
    }
    
    //see last.
    //why i > 0 doesn't work but i > start works ?
    //Let's take an example [1, 2, 2]. If we do i > 0. When we are at i = 2 condition i > 0 && nums[i] == nums[i-1] will be true and will skip a potential candidate i.e we won't add the last 2 to our       //[1, 2](current ans). So, we have to consider the case when we will atleast go into the recursion once with duplicates.
    //If we do i > start(2) in this case we will include the last 2 in our current set. That's what we want.
    
}