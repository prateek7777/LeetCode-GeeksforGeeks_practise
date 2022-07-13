class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        for(int i = n-1; i>=0; i--){      //starting at the last element of the array(units place)(least significant bit).
           if(digits[i] < 9){
               digits[i]++;
                return digits;  //we are returning here, hence all the elements of digits won't get updated. only one element gets incremented by 1.
           }
        digits[i] = 0;  //if digits[i] == 9. //until, the elements become less than 9, they keep getting replaced by 0. 
        }
        int[] newDigits = new int[n+1];   //if all the elements of digits are 9. consider digits = [9, 9, 9]. we just create a new array newDigits = [0, 0, 0, 0]
        newDigits[0] = 1;                 //then, newDigits[] = [1, 0, 0, 0].
        return newDigits;                 //returning the new array newDigits. //here, newDigits[] = [1, 0, 0, 0]. digits[] = [0, 0, 0].
    }
}