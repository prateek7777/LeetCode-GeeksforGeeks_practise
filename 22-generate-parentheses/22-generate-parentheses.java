class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> answer = new ArrayList<>();
        createParenthesis(0, 0, n, "", answer);
        return answer;
        
    }
    
    public void createParenthesis(int openPCount, int closePCount, int n, String expression, List<String> answer){
        
        if(openPCount == closePCount && closePCount == n){
            answer.add(expression);
            return;
        }
        
        if(openPCount < n)
            createParenthesis(openPCount+1, closePCount, n, expression+"(", answer);
        
        if(closePCount < openPCount)
             createParenthesis(openPCount, closePCount+1, n, expression+")", answer);
        
        return;
   
    }
    
}