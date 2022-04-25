class Solution {
    public double myPow(double x, int n) {
        long nn = n;
        if(nn==0)
            return 1;
        
        if(nn<0)
            nn = nn * -1;
        
        double ans = 1.0;
        
        while(nn>0)
        {
            if(nn%2==1)
            {
                ans = ans * x;
                nn = nn - 1;
            }else{
                 x = x * x;
                 nn = nn/2;
            }
        }
            
        if(n<0)
            return (double) 1.0 / (double) ans;
            
        return (double) ans;
        
    }
}