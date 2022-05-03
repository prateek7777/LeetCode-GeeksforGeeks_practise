class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int i = 0;
        String prefix = "";
        prefix = strs[0];   //consider the entire first word of the string array as prefix.
        // .indexOf() returns 0 for matching, returns -1 for not matching.
        for(i = 1; i<n; ){
        //indexOf() function compares string at strs[i] and prefix string.
            if(strs[i].indexOf(prefix) != 0)                      //while(strs[i].indexOf(prefix) != 0) can also be used instead of if-else.
                prefix = prefix.substring(0, prefix.length()-1);  //chop the prefix by 1 if the function returns -1.
            else
                i++;   //if the function returns 0(prefix is matching), iterate ahead without chopping the string prefix.
            
        }
    
        return prefix;
        
    }
}