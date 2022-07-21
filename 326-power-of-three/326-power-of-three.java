class Solution {
    public boolean isPowerOfThree(int n) {
        
        if(n <= 0)
            return false;   
        
        if(n == 1)
            return true;    //base case and also any number to the power 0 is 1. so, 1 applies for all numbers.
        
        if((n%3 == 0) && (isPowerOfThree(n/3) == true)) //if n is divisible by 3 and only true is returned in all the subsequent recursive fuction calls. n keeps on getting decremented in each function 
                                                        //call.
            return true;
        else
            return false;
        
    }
}