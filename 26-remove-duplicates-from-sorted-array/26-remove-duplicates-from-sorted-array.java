class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i = 0;     //i=0, j=1.
        //i is used to track the non-duplicate elements.
        for(int j = 1; j<nums.length; j++){
            
            if(nums[j] != nums[i])           //non-duplicate element found.
            {                                //the first element is always non-duplicate and is counted as well. 
                i++;                         //prepare i for storing the next non-duplicate element.
                nums[i] = nums[j];           //the non-duplicate element is put at the ith place.
            }                               
            
        }                                    //thus, at the end of the iteration, i will represent the index of the last non-duplicate element.
        return i+1;                          //the size will be i+1.(if 3 is index of the last non-duplicate element, the size will be 4).
                                             //i always iterates over the non-duplicate elements only. since, we need the size only, we return it.
    }
}