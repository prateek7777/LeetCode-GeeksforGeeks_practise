class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int consider_max = 0;
        
        //Moore's Voting Algorithm
//consider nums = [2,2,2,3,4]. consider_max won't change, because count will never reach zero. it will be 0,1,2,3,2,1.
//Thus, Moore's Voting Algorithm works.        
        for(int num : nums){
            
            if(count==0)
                consider_max = num;
            
            if(consider_max==num)
                count++;
            else
                count--;
        
        }
        
        return consider_max;
                    
        }
        
    }