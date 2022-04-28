class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    public int mergeSort(int[] nums, int low, int high){
        if(low>=high)
        return 0;
        int mid = (low+high)/2;
        int f_count = mergeSort(nums, low, mid);
        f_count = f_count + mergeSort(nums, mid+1, high);
        f_count = f_count + merge(nums, low, mid, high);
        
        return f_count;
    }
    
    public int merge(int[] nums, int low, int mid, int high){
        int count = 0;
        int j = mid+1;
        for(int i = low; i<=mid; i++)
        {
            while(j<=high && nums[i]>(2 * (long) nums[j])){
                j++;
            }
            count = count + (j-(mid+1));
        }
        
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        
        int left = low;
        int right = mid+1;
        
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
            sorted.add(nums[left++]);
            }
            else{
            sorted.add(nums[right++]);
        }
        }
        
        while(left<=mid)
        sorted.add(nums[left++]);
        
        while(right<=high)
        sorted.add(nums[right++]);
        
        for(int i=low; i<=high; i++){
            nums[i] = sorted.get(i-low);
        }
        
    return count;
    }
    
    
}