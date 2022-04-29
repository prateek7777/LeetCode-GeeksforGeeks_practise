class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        int target_2 = 0;
        int two_sum = 0;
        
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();     //List of List of quadruplets.
        
        if(nums == null || n == 0)
            return result;                             //return empty result list.
        
        Arrays.sort(nums);                             //sorting to make sure that the pointers in the code don't have to be iterated over and over again.
        
        for(int i = 0; i<n; i++){                      //i(1st) pointer, which stores the 1st input of the quadruplet. i<n = i<=n-1. i<n-1 will throw an error.
            for(int j = i+1; j<n; j++){                //j(2nd) pointer, which stores the 2nd input of the quadruplet. j<n-1 will throw an error. j = i + 1. Always.
            
            target_2 = target - (nums[i]+nums[j]);     //if two_sum==target_2. => target - (nums[i]+nums[j]) - (target_2) = 0. Which is the required logic.
                
            int left = j + 1;                          //left(3rd) pointer, which stores the 3rd input of quadruplet. left = j + 1. Always.
            int right = n - 1;                         //right(4th) pointer, which stores the 4th input of quadruplet.
        
            while(left<right){
                    
            two_sum = nums[left] + nums[right];        //two_sum as per the requirement in the logic.
                
                if(two_sum < target_2)                 
                    left++;                            //two_sum has to be increased. Sorted array helps here.
                
                else if(two_sum > target_2)           
                    right--;                           //two_sum has to be decreased. Sorted array helps here.
                
           else                                        //two_sum == target_2.
           {                                           
               
               ArrayList<Integer> quadruplet = new ArrayList<Integer>();               //single list of quadruplet. Refresh the quadruplet list.
               
               quadruplet.add(nums[i]);
               quadruplet.add(nums[j]);
               quadruplet.add(nums[left]);
               quadruplet.add(nums[right]);
               
               result.add(quadruplet);
               
               while(left < right && nums[left]==quadruplet.get(2))                    //==quadruplet.get(2); Not nums[2].
                   left++;                                                              //crossing over the duplicates, as UNIQUE quadruplets are required.
               
               while(left < right && nums[right]==quadruplet.get(3))                   //==quadruplet.get(3); Not nums[3].
                   right--;                                                             //crossing over the duplicates, as UNIQUE quadruplets are required.
               
           }
                
            }
               
               while(i+1 < n-1 && nums[i+1]==nums[i]) //not nums[i+1]==nums[0]               //nums[i+1]==nums[i]; Not nums[i]==nums[i] because, for(int i) loop is also incrementing from the top.
                   i++;                                                                 //crossing over the duplicates, as UNIQUE quadruplets are required.
               
               while(j+1 < n-1 && nums[j+1]==nums[j]) //not nums[j+1]==nums[1]              //nums[j+1]==nums[j]; Not nums[j]==nums[j] because, for(int j) loop is also incrementing from the top.
                   j++;                                                                 //crossing over the duplicates, as UNIQUE quadruplets are required.
                
        }
        }
        
        return result;
    }
}