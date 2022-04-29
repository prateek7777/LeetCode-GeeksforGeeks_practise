class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        int target_2 = 0;
        int two_sum = 0;
        
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(nums == null || n == 0)
            return result;
        
        Arrays.sort(nums);
        
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
            
            target_2 = target - (nums[i]+nums[j]);
                
            int left = j + 1;
            int right = n - 1;
        
            while(left<right){
                    
            two_sum = nums[left] + nums[right];
                
                if(two_sum < target_2)
                    left++;
                
                else if(two_sum > target_2)
                    right--;
                
           else
           {
               
               ArrayList<Integer> quadrapulet = new ArrayList<Integer>();
               
               quadrapulet.add(nums[i]);
               quadrapulet.add(nums[j]);
               quadrapulet.add(nums[left]);
               quadrapulet.add(nums[right]);
               
               result.add(quadrapulet);
               
               while(left < right && nums[left]==quadrapulet.get(2))
                   left++;
               
               while(left < right && nums[right]==quadrapulet.get(3))
                   right--;
               
           }
                
            }
               
               while(i+1 < n-1 && nums[i+1]==nums[i])
                   i++;
               
               while(j+1 < n-1 && nums[j+1]==nums[j])
                   j++;
                
        }
        }
        
        return result;
    }
}