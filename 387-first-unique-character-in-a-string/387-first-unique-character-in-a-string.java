class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> memo = new HashMap<>();
        
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            memo.put(c,memo.getOrDefault(c,0)+1);        //assign the count(int) of each character to its key(char).
        }                                                //getOrDefault is used to avoid the runtime error when the HashMap returns null(it returns 0 instead).
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);             
            
            if(memo.get(c) == 1)                //as per the question.
                return i;
        }
        return -1;                                //as per the question.
        
    }
}