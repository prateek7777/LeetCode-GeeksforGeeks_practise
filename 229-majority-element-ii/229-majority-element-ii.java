class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        int length = nums.length;
        //Boyer-Moore's Voting Algorithm.
        for(int num: nums){
            
            if(num == num1)
                count1++;
            else if(num == num2)
                count2++;
            else if(count1 == 0){
                num1 = num;         //everytime counter1 is refreshed, the next iteration num is assigned to num1.
                count1 = 1;         //assigning num to num1 in itself is a count.
            }else if(count2 == 0){
                num2 = num;         //everytime counter2 is refreshed, the next iteration num is assigned to num2.
                count2 = 1;         //assigning num to num2 in itself is a count.
            }else{
                count1--;           //if num1 is a majority element, decrementing count1 will not make count1 reach zero.
                count2--;           //if num2 is a majority element, decrementing count2 will not make count2 reach zero.
            }
        }
        
        ArrayList<Integer> f_ans = new ArrayList<Integer>();
        
        count1 = 0;                //re-initialize count1 to avoid error.
        count2 = 0;                //re-initialize count2 to avoid error.
        
        for(int num : nums){
            if(num == num1)
                count1++;
            
        else if(num == num2)    /*if    else if" is required because "if  if" will not work for identical numbers in nums. Both the counters will get */                 count2++;          //-updated for the same identical value. Thus, the output for [0,0,0] will be [0,0] while it should be [0].
        }
        
        if(count1 > length/3)
            f_ans.add(num1);      //add num1 to the list directly here.
        
        if(count2 > length/3)
            f_ans.add(num2);      //add num2 to the list directly here.
        
        return f_ans;
        
    }
}