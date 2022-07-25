class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> memo = new HashMap<>();
        
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            memo.put(c,memo.getOrDefault(c,0)+1);
        }
        
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(memo.get(c) == 1)
                return i;
        }
        
        return -1;
        
    }
}