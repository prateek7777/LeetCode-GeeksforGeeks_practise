class Solution {
    public boolean canArrange(int[] arr, int k) {
     
        int[] memo = new int[k];                           //for storing the frequency of the remainders(currRem).
        
        for(int currVal : arr){                           
            
            int currRem = ((currVal%k)+k)%k;               //remainder for both the positive and negative integers of the array.
            memo[currRem] = memo[currRem] + 1;             //incrementing the count of the particular remainder for the particular number.
            
        }
        
        for(int i=0; i<=k/2; i++){                        //i<=k/2 so that you don't miss the testcase of i = 3, if k = 6.
            
            if(i==0){                                     //if remainder = 0.
               if(memo[i]%2 != 0)                         //the count of the remainder 0 should be even so that it cancels itself out.
                   return false;
            }
            
            else{         
                int y = k-i;                              // count((i) % k) == count((y+i) % k) so that the different numbers(1,5). (i=1,y=5,k=6) are canceling out each other.
                
                if(memo[i]!=memo[y])                      //if the count of numbers is not equal, they cannot cancel out each other. Thus, returning false as atleast 1 or more pairs exist,
                    return false;                         //where, both the numbers are not divisible by k.
            }
            
        } // (a,b) % K. if a number 'a' is divisible by X, then the other number 'b' should be divisible by 'K-X'.
        
        return true;
        //K is dividing both 'a' and 'b'.
    }   //X is dividing 'a'.
}       //K-X should divide 'b'.