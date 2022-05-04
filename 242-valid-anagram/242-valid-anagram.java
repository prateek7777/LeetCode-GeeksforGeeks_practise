class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) //obviously, if the count of chars is not same, it is impossible for two the strings to be anagrams.
            return false;
        
         char[] char_counter = new char[26];              //the char[] array for 26 alphabets.
        
        for(int i = 0; i<s.length(); i++){
        //consider s = "anagram" , t = "nagaram".
           char_counter[s.charAt(i) - 'a']++;     //char['a'-'a'] = char[0]++ = 0+1 = 1. char_counter[0] = 1.
           char_counter[t.charAt(i) - 'a']--;     //char['a'-'a'] = char[0]-- = 1-1 = 0. char_counter[0] = 0.
            //char_counter[s.charAt(i) - 'a']. (- 'a') returns the index.
        }
        
        int sum = 0;                                   //Alternatively.
        for(int ch : char_counter)                     //for(int ch : char_counter)
        {                                               //{
            sum = sum + ch;            //0+0 = 0.      //if(ch!=0)
        }                                              //return false;
                                                       //}
        if(sum==0)                                     //return true;
            return true;     
        else
            return false; 
    }
}