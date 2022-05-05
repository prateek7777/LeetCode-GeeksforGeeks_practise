class Solution {
    public String countAndSay(int n) {
        
        if(n==0)                                                                   //base case.
            return "";
        // if(n==2)                                                                //not required.
        //     return "11";
        
        String t = "";
        String s = "1";                                                           //Start with String s = "1". Because after n = 1, we need to modify the same string for n>1.
        int counter = 1;                                                          //because each char of string s has atleast 1 char(= 1 count). thus, counter = 1.
        
        for(int i=2; i<=n; i++){ //i<=n  because n is not string length. it's an input given in the question. //i = 2, because, s = "1". So we start with i = 2. if s = "11", we start with i = 3.
            s = s + "!";         //see last. 
            t = "";              //temporary string.
            for(int j = 1; j<s.length(); j++){
                if(s.charAt(j) != s.charAt(j-1))          //compare the current char(j) and the previous char(j-1).            
                {
                    t = t + Integer.toString(counter);    //as per the question.
                    t = t + s.charAt(j-1);                //as per the question.
                    counter = 1;                          //reset the counter.
                }
                else
                    counter++;                            //if the current char(j) and the previous char(j-1) are same, we need to increment the counter. Not attach it to the string output.
            }
            s = t;                                        //updating the final string output with the temporary string.   
        }
        return s;                                         //returning the final output.
    }
}

//s = s + "!"
// = s + : update the iterations of the temporary string to the final string output.
// + "!" : Whenever we get a character that is unequal to the previous character,we add the previous add our answer for the previous number to the string t. So for the last number in the string we wont get any inequality and hence it wont get added to string t. This is why we added a random character at the end so that random character becomes unequal to the last character of the actual string and we could get the desired answer.