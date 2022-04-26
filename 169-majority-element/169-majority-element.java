class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int consider_max = 0;
        
        //Moore's Voting Algorithm
        
        for(int num : nums){
            
            if(count==0)
                consider_max = num;
            
            if(consider_max==num)
                count--;
            else
                count++;
        
        }
        return consider_max;
                    
        }
        
    }