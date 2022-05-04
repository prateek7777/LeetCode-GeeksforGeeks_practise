class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        
        if(n==0)      //as per the question, if the needle is an empty string, we should return 0.
            return 0;
        
        if(n>h)           //a needle larger than the haystack itself cannot exist in the haystack.
            return -1;
        //consider haystack = "Hello", needle = "ll".
        for(int i = 0; i<h-n+1; i++){ //i<h => traverse through the entire haystack; i<h-m => traverse in haystack from H to l(index 2). But we need to go until l(index 3). ; i<h-n+1 => traverse from                                         //H to l(index 3) as per the requirement.
            if(haystack.substring(i, i+n).equals(needle)) // (He).equals(ll); (el).equals(ll); (ll).equals(ll) return 2.
                return i;
            
            }
        
        return -1;        //after traversing through the entire loop, if there is no needle found in the haystack, return -1.
        
    }
}