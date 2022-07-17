class Solution {
    public List<String> letterCombinations(String digits) {
        
        LinkedList<String> out_arr = new LinkedList();
        
        if(digits.length() == 0)
            return out_arr;
        
        String[] combination_map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
                                                 "tuv", "wxyz"};
        
        out_arr.add("");
        
        for(int i = 0; i<digits.length(); i++){
            int index = Character.getNumericValue(digits.charAt(i));
            while(out_arr.peek().length() == i){
                String permutation = out_arr.remove();
                for(char c : combination_map[index].toCharArray()){
                    out_arr.add(permutation+c);
                    }
            }
        
        }
        return out_arr;
    }
}