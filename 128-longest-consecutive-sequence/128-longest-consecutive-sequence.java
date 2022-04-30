class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int num : nums)
            hashSet.add(num);
        
        int longest_Streak = 0;
        int curr_Streak = 1;
        for(int num : nums){
            
            if(!hashSet.contains(num-1)){
                int curr_Num = num;
                curr_Streak = 1;
            
            while(hashSet.contains(curr_Num+1)){
                curr_Num = curr_Num+1;
                curr_Streak = curr_Streak+1;
            }
                
            }
            
            longest_Streak = Math.max(curr_Streak, longest_Streak);
            
        }
        return longest_Streak;
    }
}