class Solution {
    public boolean isPalindrome(String s) {
        String fixedString = "";
        
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch) || Character.isDigit(ch))
                fixedString = fixedString + ch;
        }
        
        fixedString = fixedString.toLowerCase();
        
        int aPointer = 0;
        int bPointer = fixedString.length()-1;
        
        while(aPointer <= bPointer){
            if(fixedString.charAt(aPointer) != fixedString.charAt(bPointer))
                return false;
            
            aPointer++;
            bPointer--;
        }
        return true;
    }
}