class Solution {
    public double myPow(double x, int n) {
        long nn = n;    //int is converted to long.
        if(nn==0)
            return 1;   //base case.
        
        if(nn<0)
            nn = nn * -1;  //if the power is negative.
        
        double ans = 1.0;  //not double ans = 0.0
        
        while(nn>0)               //the power n will iterate from n to 1. 
        {
            if(nn%2==1)           //if the power is odd.
            {
                ans = ans * x;    //compute 4^5 using pen and paper.
                nn = nn - 1;      //whether the n is positive or negative, it ultimately goes to line 16.
            }else{
                 x = x * x;       //compute 4^4 using pen and paper.
                 nn = nn/2;
            }
        }
            
        if(n<0)
            return (double) 1.0 / (double) ans;   //x^-1 = 1/(x^n).
            
        return (double) ans;   //convert the ans variable from long to double.
                               //long is used, because, int ranges from -2,147,483,648 (-2^31) to 2,147,483,647 (2^(31)-1). There is one extra integer
    }                          //on the negative side of the range.
}