class Solution {
    public int myAtoi(String s) {
        
        if(s == null || s.length() == 0)                 //if string is null or string length is 0.
            return 0;
        
        int index = 0;              
        int n = s.length(); 
        double result = 0;   //double so that even if the value of the integer is more than the Integer.MAX_VALUE or if the value of the integer is less than Integer.MIN_VALUE, we don't get
                             //-stack overflow error.
        while(index<n && s.charAt(index) == ' ')        //eliminating all the empty spaces in the begining of the input string.
            ++index;
        
        boolean isNegative = false;                     //used for sign(+ or -).
         
        if(index<n){                                    //for "+-123" input and similar inputs.
        if(s.charAt(index) == '-'){                     //check for negative sign.
            isNegative = true;
            ++index;                                    //iterate through until reaching a negative sign.
        }else if(s.charAt(index) == '+'){               //check for positive sign.
            isNegative = false;                        
            ++index;                                    //iterate through until reaching a positive sign.
        }
        }     
         
        for(int i = index; i<n; i++){                   //use int i = index, not int i = 0.
             
            if(s.charAt(i) < '0' || s.charAt(i) > '9')       //if input is "ab123", return 0.
                break;
            
            if(s.charAt(index) == '+' || s.charAt(index) == '-')   //iterate so that if input is "+123", take the index to 1, so that we can start calculating the integer from the input string.
            index = index + 1;                     
            
            int digit = s.charAt(i) - '0';               //if input is '2'. digit = ascii(2) - ascii(0).(2 = 50 - 48).
            result = result*10 + digit;                  //calculate the result by multiplying the digits with 10. units*10 -> tens*10 -> hundreds*10 -> thousands*10 -> so on.
        }
       
           if(isNegative == true)                        //if result is negative.
            result = result*-1;
        
        if(result<Integer.MIN_VALUE)                      //double data type result won't cause any issue here. int will.
            return Integer.MIN_VALUE;                     //return min value as per the requirement.
        else if(result>Integer.MAX_VALUE)                 //double data type result won't cause any issue here. int will.
            return Integer.MAX_VALUE;                     //return max value as per the requirement.

        return (int)result;                               //convert double to int as the return type is int.
            
    }
}