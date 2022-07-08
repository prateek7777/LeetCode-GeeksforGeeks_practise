class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();     //final answer.
        List<String> part = new ArrayList<>();  //sub answer.
        helper(s, 0, part, answer);  //starting with index 0 and string s.
        return answer;  //returning the final answer.
    }
    
    public List<List<String>> helper(String s, int index, List<String> part, List<List<String>> answer){
     
        if(index == s.length())  //if the index has reached to the end of the string s, it implies that all the current partitions are palindromes.
        {                        //base case.
            answer.add(new ArrayList<>(part));     //adding the sub answer to the final answer with the new keyword to avoid empty list outputs. the "new" keyword leads to allocation of new memory.
            return answer;
        }
        
        for(int i = index; i<s.length(); i++){    //the iteration starts with the index in the function call in line 22. for the first time, it's line 5.
        //if the if case fails, i gets incremented with index remaining the same. if the if case is true, both i and index get incremented at the same time.
            if(isPalindrome(s, index, i)){    //if this loop fails, we check, if the bigger string is palindrome, by just incrementing i, keeping index same. also, otherwise, we just increment both
                                           //i and index, to get the next sub answer(the next substring to be precise).
                part.add(s.substring(index, i+1));  //if s is palindromic from index to i, the substring would be naturally, index to i+1.
                helper(s, i+1, part, answer);   //after updating the sub answer, prepare the function call for the next iteration. basically, increment index for the next iteration. i gets incremented                                                 //on its own.
                part.remove(part.size()-1);   //while backtracking, we naturally remove the latest element that was added as per the function calls. because we are going back.
            }
        }
        return answer;
    }
    
    public Boolean isPalindrome(String s, int start, int end){
        
        while(start<=end){   //important. if missing, we have a testcase failing where, the start is greater than end.
        if(s.charAt(start++) != s.charAt(end--))       //checking for same characters.
            return false;                              //return false immediately, if not same characters.
        }
        return true;         //if the iteration from start to end is over and there are no issues.
        
    }
    
}