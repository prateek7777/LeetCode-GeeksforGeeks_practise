class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int release = 0;
        int answer = 0;
        HashMap<Character, Integer> memo = new HashMap<>();
        int n = s.length();
        
        release = 0;                                       //initialising release to 0.
        for(int acquire = 0; acquire<n; acquire++){        //start iterating from acquire = 0.
            
            char currChar = s.charAt(acquire);             //the base, or the very first element that has to be started with.
            
            while(release<acquire && memo.containsKey(currChar)){         //releasing the element, in case, it is repeating.
                char discardChar = s.charAt(release);                 
                memo.remove(discardChar);                    //removing(discarding) the element present at release pointer.
                release = release + 1;               //since the element(char) at release has been discarded, release pointer is incremented.
            }
            
            memo.put(currChar, acquire);                       //if the element is not repeating, the char has to be put in the HashMap, with its index assigned as its value.
            //longest -> memo.put(currChar, index); count -> memo.put(currChar, frequency).
            answer = Math.max(answer, acquire-release+1);  //the maximum because, the length of the "longest" substring has to be found.
            //also, the length of the valid substring will be (acqurie-release+1).
        }
        return answer;
        //keep on acquiring until an invalid case is encountered, keep on releasing until a valid case is encountered.
        
    }
}