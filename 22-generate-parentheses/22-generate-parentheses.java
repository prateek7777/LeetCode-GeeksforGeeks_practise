class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> answer = new ArrayList<>();
        createParenthesis(0, 0, n, "", answer);
        return answer;
        
    }
    
    public void createParenthesis(int openPCount, int closePCount, int n, String expression, List<String> answer){
        
        if(openPCount == closePCount && closePCount == n){          //openPCount=2=closePCount, but n = 3. Thus, closePCount == n.   //base case.
            answer.add(expression);
            return;
        }
        
        if(openPCount < n)         //obviously.
            createParenthesis(openPCount+1, closePCount, n, expression+"(", answer);
        
        if(closePCount < openPCount)   //we don't need to validate the string expression. we add the ")" only if there is a corresponding "(".
             createParenthesis(openPCount, closePCount+1, n, expression+")", answer);
        //the ")" itself is the backtrack.
        
        return;
   
    }
    
}