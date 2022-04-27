class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        int c1 = 0;
        int c2 = 0;
        int length = nums.length;
        
        for(int num: nums){
            
            if(num == num1)
                count1++;
            else if(num == num2)
                count2++;
            else if(count1 == 0){
                num1 = num;
                count1 = 1;
            }else if(count2 == 0){
                num2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        
        ArrayList<Integer> f_ans = new ArrayList<Integer>();
        
        c1 = 0;
        c2 = 0;
        
        for(int num : nums){
            if(num == num1)
                c1++;
            
        else if(num == num2)
                c2++;
        }
        
        if(c1 > length/3)
            f_ans.add(num1);
        
        if(c2 > length/3)
            f_ans.add(num2);
        
        return f_ans;
        
    }
}