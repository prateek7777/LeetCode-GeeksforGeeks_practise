class Solution {
    public boolean isPowerOfTwo(int n) {
     if(n<=0)
         return false;
        //n = 16   = 1 0 0 0 0
        // & 
        //n-1 = 15 = 0 1 1 1 1
        //         = 0 0 0 0 0 
        if((n & (n-1)) == 0)
            return true;
        else
            return false;
    }
}