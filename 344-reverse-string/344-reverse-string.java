class Solution {
    public void reverseString(char[] s) {
        
        int aPointer = 0;
        int bPointer = s.length-1;
        //self-explanatory.
        while(aPointer <= bPointer){
            
            char c = s[aPointer];
            s[aPointer] = s[bPointer];
            s[bPointer] = c;
            
            aPointer++;
            bPointer--;
        }
        
    }
}