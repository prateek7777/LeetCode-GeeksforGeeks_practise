class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int consider_max = 0;
        
        //Moore's Voting Algorithm
//consider nums = [2,2,2,3,4]. consider_max won't change, because count will never reach zero. It will be 0,1,2,3,2,1.
//Thus, Moore's Voting Algorithm works.        
        for(int num : nums){
            
            if(count==0)               //0
                consider_max = num;    //consider_max = 2. (will remain same).
            
            if(consider_max==num)
                count++;              //0,1,2,3.
            else
                count--;              //2,1.
        
        }
        
        return consider_max;
                    
        }
        
    }