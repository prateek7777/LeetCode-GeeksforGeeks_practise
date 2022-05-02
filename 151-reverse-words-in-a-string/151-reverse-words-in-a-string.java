class Solution {
    public String reverseWords(String s) {             //Hello World!
        int n = s.length();
        int i = 0;
        int j = 0;
        String f_result = "";
        String result = "";
        while(i<n){
            
            while(i<n && s.charAt(i) == ' ')           //iterate through white space between the words.
                i++;
            
            if(i==n)                                   //if i == n, you cannot do j = i+1. It causes stack overflow error.
            break;
            
            j = i+1;                                   //i will stop at the very end of white space. immediately after i, j will iterate through each individual word.
            
            while(j<n && s.charAt(j) != ' ')           //j will iterate through each word until it reaches a white space.
                j++;
            
            result = s.substring(i, j);                //result will store each word which will range from i to j. Hello; World!
            
            i = j+1;                                   //i again goes for the next white space and the loop continues till the end of the string.
            
            if(f_result.length() == 0)                 //the very first word will be put in f_result.
                f_result = result;                     //Hello
            else
                f_result = result + " " + f_result;    //we can clearly see the reversing of the words. f_result is being put after the result. //World! Hello
                                     
        }
        
        return f_result;                               
        
    }
}