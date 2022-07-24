class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> memo = new HashSet<>();
        //self-explanatory.
        for(int i=0; i<nums.length; i++){
            if(memo.contains(nums[i]))
                return true;
            
            memo.add(nums[i]);
        }
        
        return false;
        
    }
}