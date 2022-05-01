class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        String f_result = "";
        String result = "";
        while(i<n){
            
            while(i<n && s.charAt(i) == ' ')
                i++;
            
            if(i==n)
            break;
            
            j = i+1;
            
            while(j<n && s.charAt(j) != ' ')
                j++;
            
            result = s.substring(i, j);
            
            i = j+1;
            
            if(f_result.length() == 0)
                f_result = result;
            else
                f_result = result + " " + f_result;
         
        }
        
        return f_result;
        
    }
}