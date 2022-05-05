class Solution {
    public String countAndSay(int n) {
        
        
        if(n==1)
            return "1";
        if(n==2)
            return "11";
        
        
        String t = "";
        String s = "1";
        int counter = 0;  
        
        for(int i=2; i<=n; i++){
            s = s + "!";
            t = "";
            counter = 1;
            for(int j = 1; j<s.length(); j++){
                if(s.charAt(j-1) != s.charAt(j))
                {
                    t = t + Integer.toString(counter);
                    // t = t+counter;
                    t = t + s.charAt(j-1);
                    counter = 1;
                }
                else
                    counter++;
            }
            s = t;
        }
        return s;
    }
}