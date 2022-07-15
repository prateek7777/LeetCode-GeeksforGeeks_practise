class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        // a^a = 0. a^0 = a.        
        for(int i=0; i<nums.length; i++){
            //all the duplicate numbers will end up becoming 0.
            result = result ^ nums[i];        //XOR.
            //only the unique(single) number will be remaining after the entire iteration because, there is no duplicate of it to convert it into 0.
        }
        return result;        //the unique/single number.
    }
}