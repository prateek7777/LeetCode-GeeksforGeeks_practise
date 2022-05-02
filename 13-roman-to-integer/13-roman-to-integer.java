class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> convertMap = new HashMap<Character, Integer>();
        convertMap.put('I', 1);             //put the values as given in the question.
        convertMap.put('V', 5);
        convertMap.put('X', 10);
        convertMap.put('L', 50);
        convertMap.put('C', 100);
        convertMap.put('D', 500);
        convertMap.put('M', 1000);
        
        int roman = convertMap.get(s.charAt(s.length()-1));              //the very last character in the input string.
        for(int i = s.length()-2; i>=0; i--){               //we start iterating from the second last char in the input string.
            if(convertMap.get(s.charAt(i)) < convertMap.get(s.charAt(i+1)))  //1 < 5 => IV.
                roman = roman - convertMap.get(s.charAt(i));                 //5 - 1 = 4.
            else                                                             //5 > 1 => VI.
                roman = roman + convertMap.get(s.charAt(i));                 //5 + 1 = 6.
        }
        return roman;
    }
}