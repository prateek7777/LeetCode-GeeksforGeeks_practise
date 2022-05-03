class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int i = 0;
        String prefix = "";
        prefix = strs[0];
        
        for(i = 1; i<n; i++){
        
            while(strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length()-1);
            
        }
        
        return prefix;
        
    }
}