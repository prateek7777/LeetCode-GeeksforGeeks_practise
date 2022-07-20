class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        
        if(n == 1)         //base case and also any number to the power 0 is 1. so 1 applies for all numbers.
            return true;
        
        if((n % 2 == 0) && (isPowerOfTwo(n/2) == true))        //n%2 will keep on decrementing the number and the function call will keep checking and returning true.
            return true;
        else
            return false;   //if any one of the condition of line 9 fails, we return false.
    }
}