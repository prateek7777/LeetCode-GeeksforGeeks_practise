class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    public int mergeSort(int[] nums, int low, int high){
        if(low==high)                                              //base case
        return 0;
        int mid = (low+high)/2;                                    //not (nums.length)/2
        int f_count = mergeSort(nums, low, mid);                   //count from the left half.
        f_count = f_count + mergeSort(nums, mid+1, high);          //count from the right half.
        f_count = f_count + merge(nums, low, mid, high);           //overall count from both left and right halves.
        
        return f_count;
    }
    
    public int merge(int[] nums, int low, int mid, int high){
        int count = 0;
        int j = mid+1;                                             //j is for the right half. It ranges from (mid+1) to high.
        for(int i = low; i<=mid; i++)                              //use a for loop. Not a while loop. i is for the first half. It ranges from low to mid.
        {
            while(j<=high && nums[i]>(2 * (long) nums[j])){        //The condition that has to be satisfied.
                j++;
            }
            count = count + (j-(mid+1));                           //Since j is getting incremented on the basis of the given condition, j-(mid+1) will be                                                                      //-having the required count.
        }
        
        //Merge Sort.
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        int left = low;
        int right = mid+1;
        
        while(left<=mid && right<=high){                  //main sorting.
            if(nums[left]<=nums[right]){
            sorted.add(nums[left++]);
            }
            else{
            sorted.add(nums[right++]);
        }
        }
        
        while(left<=mid)
        sorted.add(nums[left++]);                         //leftover left elements.
        
        while(right<=high)
        sorted.add(nums[right++]);                        //leftover right elements.
        
        for(int i=low; i<=high; i++){
            nums[i] = sorted.get(i-low);                 //return type is array. So, copy all the elements of the list to the array.
        }
        
    return count;                                        //return the count.
    }
       
}