class Solution {
    public boolean isPalindrome(String s) {
        String fixedString = "";
        
        for(char ch : s.toCharArray()){      //string to charArray.
            if(Character.isLetter(ch) || Character.isDigit(ch))  //the first part checks if its a letter while the second part checks if its a number.(alphanumeric)
                fixedString = fixedString + ch;
        }
        
        fixedString = fixedString.toLowerCase();            //for ignoring case. can be converted to upper case as well.
        
        int aPointer = 0;      //left pointer.
        int bPointer = fixedString.length()-1;   //right pointer.
        
        while(aPointer <= bPointer){   //until the left and the right pointer meet in the middle of fixedString.
            if(fixedString.charAt(aPointer) != fixedString.charAt(bPointer))  //not a palindrome. 
                return false;
            
            aPointer++;   //going inwards.
            bPointer--;   //going inwards.
        }
        return true;     //a palindrome.
    }
}