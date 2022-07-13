class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();     //the output list.
        Arrays.sort(nums); //the 2 pointer method with the pointers going inwards works only if the array is sorted.
        for(int i=0; i<nums.length-2; i++){  //because we have to look at look two elements after the current element without going out of bounds.
         if(i == 0 || (i>0 && nums[i] != nums[i-1])){    //eliminate duplicates for the 3 sum block of code without index out of bounds.
             int low = i+1;   //the left pointer.
             int high = nums.length-1;  //the right pointer.
             int sum = 0-nums[i];   //the initial sum for the 3 sum block of code.
             while(low<high){     //as usual in the 2 pointer method.
                 
                 if(nums[low] + nums[high] == sum){ //implying that (nums[i]+nums[low]+nums[high] = 0).
                     
                     output.add(Arrays.asList(nums[i],nums[low],nums[high]));   //syntax. as temporary list of 3 elements.
                     while(low<high && nums[low] == nums[low+1])low++;          //eliminate duplicates for the 2 sum block of code. (low<high) is imp.
                     while(low<high && nums[high] == nums[high-1])high--;       //eliminate duplicates for the 2 sum block of code. (low<high) is imp.
                     low++;        //iterating inwards.
                     high--;       //iterating inwards.
                     
                 }
                 else if(nums[low] + nums[high] > sum)    
                     high--;          //obviously decrease the sum.
                 else
                     low++;           //obviously increase the sum.
             }

         }   
   
        }
        return output;
    }
}