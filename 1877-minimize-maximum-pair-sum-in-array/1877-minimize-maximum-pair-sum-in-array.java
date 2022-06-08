class Solution {
    public int minPairSum(int[] nums) {
        
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        
        Arrays.sort(nums);
        
        for(int i = 0; i<len; i++){
            res = Math.max(res, nums[i]+nums[len - i - 1]); 
        }
        
        return res;
        
    }
}