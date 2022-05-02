class Solution {
    public int myAtoi(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        
        int index = 0;
        int n = s.length();
        double result = 0;
        
        while(index<n && s.charAt(index) == ' ')
            ++index;
        
        boolean isNegative = false;
         
        if(index<n){
        if(s.charAt(index) == '-'){
            isNegative = true;
            ++index;
        }else if(s.charAt(index) == '+'){
            isNegative = false;
            ++index;
        }
        }     
         
        for(int i = index; i<n; i++){
            
            if(s.charAt(i) < '0' || s.charAt(i) > '9')
                break;
            
            if(s.charAt(index) == '+' || s.charAt(index) == '-')
            index = index + 1;
            
            int digit = s.charAt(i) - '0';
            result = result*10 + digit;
        
        }
       
           if(isNegative == true)
            result = -result;
        
        
        if(result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if(result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int)result;
            
    }
}