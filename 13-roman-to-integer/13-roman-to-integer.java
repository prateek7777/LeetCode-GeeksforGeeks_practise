class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> convert = new HashMap<Character, Integer>();
        convert.put('I', 1);
        convert.put('V', 5);
        convert.put('X', 10);
        convert.put('L', 50);
        convert.put('C', 100);
        convert.put('D', 500);
        convert.put('M', 1000);
        
        int roman = convert.get(s.charAt(s.length()-1));
        for(int i = s.length()-2; i>=0; i--){
            if(convert.get(s.charAt(i)) < convert.get(s.charAt(i+1)))
                roman = roman - convert.get(s.charAt(i));
            else
                roman = roman + convert.get(s.charAt(i));
        }
        return roman;
    }
}