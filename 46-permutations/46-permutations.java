class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        createPermutations(nums, answer, new ArrayList<>());    //function call.
        return answer;
    }
    
    public void createPermutations(int[] nums, List<List<Integer>> answer, List<Integer> tempList){
     
        if(tempList.size() == nums.length){        //base case. (it runs multiple times for every end of the recursive call).
            answer.add(new ArrayList<>(tempList)); //adding the sub answer to the final answer with the new keyword to avoid empty list outputs. the "new" keyword leads to allocation of new memory.
        }
        else
        { 
        for(int i=0; i<nums.length; i++){       //iterating from 0 to nums array (length-1).
            if(tempList.contains(nums[i]))        //to avoid duplicate elements.
                continue;
            tempList.add(nums[i]);               //choose. //update the sub answer.
            createPermutations(nums, answer, tempList);   //explore. //after updating the sub answer, prepare the function call for the next iteration.
            tempList.remove(tempList.size()-1);  //unchoose.  //while backtracking, we naturally remove the latest element that was added as per the function calls. because we are going back.
        }
        }
    
    }
}