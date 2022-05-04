class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
         char[] char_counter = new char[26];
        
        for(int i = 0; i<s.length(); i++){
            
           char_counter[s.charAt(i) - 'a']++;
           char_counter[t.charAt(i) - 'a']--;
            
        }
        
        int sum = 0;
        for(int ch : char_counter)
        {
            sum = sum + ch;
        }
        
        if(sum==0)
            return true;
        else
            return false;
    }
}