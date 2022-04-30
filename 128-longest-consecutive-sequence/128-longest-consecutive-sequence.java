class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int num : nums)
            hashSet.add(num);                           //populating the hashSet.
        
        int longest_Streak = 0;                         
        int curr_Streak = 0;
        for(int num : nums){                            //num = 2. nums = [2,3,4,5]
            
            if(!hashSet.contains(num-1)){              //if hashSet doesn't contain 1. 
                int curr_Num = num;                    //curr_Num = 2.
                curr_Streak = 1;                       //curr_Streak count will be 1, because 2(curr_Num) is a part of the streak.
            
            while(hashSet.contains(curr_Num+1)){       //while hashSet contains 3.4.5.            6.
                curr_Num = curr_Num+1;                 //curr_Num = 3.4.5.
                curr_Streak = curr_Streak+1;           //curr_Streak = 2.3.4.
            } 
                
            }
            
            longest_Streak = Math.max(curr_Streak, longest_Streak); //Math.max(0,4) = 4.
            
        }
        return longest_Streak;   //4.
    }
}