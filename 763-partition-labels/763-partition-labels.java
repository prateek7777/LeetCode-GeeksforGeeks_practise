class Solution {
    public List<Integer> partitionLabels(String s) {
     
        HashMap<Character, Integer> memo = new HashMap<Character, Integer>();
        int n = s.length();
        
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            memo.put(ch, i);                    //getting the impact of each alphabet of the string.
        }
        
        List<Integer> output = new ArrayList<Integer>();
        int max = 0;
        int prev = -1;
        
        for(int i=0; i<n; i++){
            
            char ch = s.charAt(i);
            max = Math.max(max, memo.get(ch));    //getting the current maximum which keeps getting updated.
            
            if(max == i){                       //creating the partition.
            
            output.add(max - prev);         //(max-prev) gives the length of the requrired partition.
            prev = max;                     //setting prev with max for the next iteration.
                
            }
            
        }
        
        return output;                 //returning the final list.
    }
}