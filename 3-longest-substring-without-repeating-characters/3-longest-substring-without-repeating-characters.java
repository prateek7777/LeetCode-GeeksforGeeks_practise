class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int release = 0;
        int answer = 0;
        HashMap<Character, Integer> memo = new HashMap<>();
        int n = s.length();
        
        release = 0;
        for(int acquire = 0; acquire<n; acquire++){
            
            char currChar = s.charAt(acquire);
            
            while(release<acquire && memo.containsKey(currChar)){
                char discardChar = s.charAt(release);
                memo.remove(discardChar);
                release = release + 1;
            }
            
            memo.put(currChar, acquire);
            answer = Math.max(answer, acquire-release+1);
            
        }
        return answer;
        
    }
}