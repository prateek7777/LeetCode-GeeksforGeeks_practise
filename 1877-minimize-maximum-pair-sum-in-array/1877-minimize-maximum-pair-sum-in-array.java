class Solution {
    public int minPairSum(int[] nums) {
        
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        
        Arrays.sort(nums);                //sorting in ascending order.
        
        for(int i = 0; i<len/2; i++){     //iterating till the first half is enough.
            res = Math.max(res, nums[i]+nums[len - i - 1]); //the first half will be half-small, the second half will be half-large.
        }                                 //we will be adding the one element from the first half and another element from the second half, from each direction.
                                          //(left to right (+) right to left).
        return res;
        
    }
}