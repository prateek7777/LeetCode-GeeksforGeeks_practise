class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> part = new ArrayList<>();
        helper(s, 0, part, answer);
        return answer;        
    }
    
    public List<List<String>> helper(String s, int index, List<String> part, List<List<String>> answer){
     
        if(index == s.length())
        {
            answer.add(new ArrayList<>(part));
            return answer;
        }
        
        for(int i = index; i<s.length(); i++){
        
            if(isBoolean(s, index, i)){
             
                part.add(s.substring(index, i+1));
                helper(s, i+1, part, answer);
                part.remove(part.size()-1);
                
            }
        }
        return answer;
    }
    
    public Boolean isBoolean(String s, int start, int end){
        
        while(start<=end){
        if(s.charAt(start++) != s.charAt(end--))
            return false;
        }
        return true;
        
    }
    
}