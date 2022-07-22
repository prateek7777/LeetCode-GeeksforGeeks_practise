class Solution {
    public boolean isPowerOfFour(int n) {
        
        if(n <= 0)
            return false;
        
        if(n == 1)          //base case and also any number to the power 0 is 1. so, 1 applies for all numbers.
            return true;
        
        if(( n % 4 == 0 ) && ( isPowerOfFour(n/4) == true )) //if n is divisible by 4 and only true is returned in all the subsequent recursive fuction calls. n keeps on getting decremented in each function call.
            return true;
           else
            return false;
    
    }
}